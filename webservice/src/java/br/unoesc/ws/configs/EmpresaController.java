/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unoesc.ws.configs;

import br.unoesc.ws.configs.util.PagingInfo;
import br.unoesc.ws.model.Empresa;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;
import javax.faces.FacesException;
import br.unoesc.ws.configs.util.JsfUtil;
import br.unoesc.ws.configs.exceptions.NonexistentEntityException;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.model.SelectItem;

/**
 *
 * @author leandro
 */
public class EmpresaController {

    public EmpresaController() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        jpaController = (EmpresaJpaController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "empresaJpa");
        pagingInfo = new PagingInfo();
        converter = new EmpresaConverter();
    }
    private Empresa empresa = null;
    private List<Empresa> empresaItems = null;
    private EmpresaJpaController jpaController = null;
    private EmpresaConverter converter = null;
    private PagingInfo pagingInfo = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(jpaController.getEmpresaCount());
        }
        return pagingInfo;
    }

    public SelectItem[] getEmpresaItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(jpaController.findEmpresaEntities(), false);
    }

    public SelectItem[] getEmpresaItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(jpaController.findEmpresaEntities(), true);
    }

    public Empresa getEmpresa() {
        if (empresa == null) {
            empresa = (Empresa) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentEmpresa", converter, null);
        }
        if (empresa == null) {
            empresa = new Empresa();
        }
        return empresa;
    }

    public String listSetup() {
        reset(true);
        return "empresa_list";
    }

    public String createSetup() {
        reset(false);
        empresa = new Empresa();
        return "empresa_create";
    }

    public String create() {
        try {
            jpaController.create(empresa);
            JsfUtil.addSuccessMessage("Empresa was successfully created.");
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("empresa_detail");
    }

    public String editSetup() {
        return scalarSetup("empresa_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        empresa = (Empresa) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentEmpresa", converter, null);
        if (empresa == null) {
            String requestEmpresaString = JsfUtil.getRequestParameter("jsfcrud.currentEmpresa");
            JsfUtil.addErrorMessage("The empresa with id " + requestEmpresaString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String empresaString = converter.getAsString(FacesContext.getCurrentInstance(), null, empresa);
        String currentEmpresaString = JsfUtil.getRequestParameter("jsfcrud.currentEmpresa");
        if (empresaString == null || empresaString.length() == 0 || !empresaString.equals(currentEmpresaString)) {
            String outcome = editSetup();
            if ("empresa_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit empresa. Try again.");
            }
            return outcome;
        }
        try {
            jpaController.edit(empresa);
            JsfUtil.addSuccessMessage("Empresa was successfully updated.");
        } catch (NonexistentEntityException ne) {
            JsfUtil.addErrorMessage(ne.getLocalizedMessage());
            return listSetup();
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return detailSetup();
    }

    public String destroy() {
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentEmpresa");
        Long id = new Long(idAsString);
        try {
            jpaController.destroy(id);
            JsfUtil.addSuccessMessage("Empresa was successfully deleted.");
        } catch (NonexistentEntityException ne) {
            JsfUtil.addErrorMessage(ne.getLocalizedMessage());
            return relatedOrListOutcome();
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return relatedOrListOutcome();
    }

    private String relatedOrListOutcome() {
        String relatedControllerOutcome = relatedControllerOutcome();
        if (relatedControllerOutcome != null) {
            return relatedControllerOutcome;
        }
        return listSetup();
    }

    public List<Empresa> getEmpresaItems() {
        if (empresaItems == null) {
            getPagingInfo();
            empresaItems = jpaController.findEmpresaEntities(pagingInfo.getBatchSize(), pagingInfo.getFirstItem());
        }
        return empresaItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "empresa_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "empresa_list";
    }

    private String relatedControllerOutcome() {
        String relatedControllerString = JsfUtil.getRequestParameter("jsfcrud.relatedController");
        String relatedControllerTypeString = JsfUtil.getRequestParameter("jsfcrud.relatedControllerType");
        if (relatedControllerString != null && relatedControllerTypeString != null) {
            FacesContext context = FacesContext.getCurrentInstance();
            Object relatedController = context.getApplication().getELResolver().getValue(context.getELContext(), null, relatedControllerString);
            try {
                Class<?> relatedControllerType = Class.forName(relatedControllerTypeString);
                Method detailSetupMethod = relatedControllerType.getMethod("detailSetup");
                return (String) detailSetupMethod.invoke(relatedController);
            } catch (ClassNotFoundException e) {
                throw new FacesException(e);
            } catch (NoSuchMethodException e) {
                throw new FacesException(e);
            } catch (IllegalAccessException e) {
                throw new FacesException(e);
            } catch (InvocationTargetException e) {
                throw new FacesException(e);
            }
        }
        return null;
    }

    private void reset(boolean resetFirstItem) {
        empresa = null;
        empresaItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Empresa newEmpresa = new Empresa();
        String newEmpresaString = converter.getAsString(FacesContext.getCurrentInstance(), null, newEmpresa);
        String empresaString = converter.getAsString(FacesContext.getCurrentInstance(), null, empresa);
        if (!newEmpresaString.equals(empresaString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }

}
