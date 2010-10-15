/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unoesc.ws.configs;

import br.unoesc.ws.configs.util.PagingInfo;
import br.unoesc.ws.model.Cidade;
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
public class CidadeController {

    public CidadeController() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        jpaController = (CidadeJpaController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "cidadeJpa");
        pagingInfo = new PagingInfo();
        converter = new CidadeConverter();
    }
    private Cidade cidade = null;
    private List<Cidade> cidadeItems = null;
    private CidadeJpaController jpaController = null;
    private CidadeConverter converter = null;
    private PagingInfo pagingInfo = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(jpaController.getCidadeCount());
        }
        return pagingInfo;
    }

    public SelectItem[] getCidadeItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(jpaController.findCidadeEntities(), false);
    }

    public SelectItem[] getCidadeItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(jpaController.findCidadeEntities(), true);
    }

    public Cidade getCidade() {
        if (cidade == null) {
            cidade = (Cidade) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentCidade", converter, null);
        }
        if (cidade == null) {
            cidade = new Cidade();
        }
        return cidade;
    }

    public String listSetup() {
        reset(true);
        return "cidade_list";
    }

    public String createSetup() {
        reset(false);
        cidade = new Cidade();
        return "cidade_create";
    }

    public String create() {
        try {
            jpaController.create(cidade);
            JsfUtil.addSuccessMessage("Cidade was successfully created.");
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("cidade_detail");
    }

    public String editSetup() {
        return scalarSetup("cidade_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        cidade = (Cidade) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentCidade", converter, null);
        if (cidade == null) {
            String requestCidadeString = JsfUtil.getRequestParameter("jsfcrud.currentCidade");
            JsfUtil.addErrorMessage("The cidade with id " + requestCidadeString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String cidadeString = converter.getAsString(FacesContext.getCurrentInstance(), null, cidade);
        String currentCidadeString = JsfUtil.getRequestParameter("jsfcrud.currentCidade");
        if (cidadeString == null || cidadeString.length() == 0 || !cidadeString.equals(currentCidadeString)) {
            String outcome = editSetup();
            if ("cidade_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit cidade. Try again.");
            }
            return outcome;
        }
        try {
            jpaController.edit(cidade);
            JsfUtil.addSuccessMessage("Cidade was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentCidade");
        Long id = new Long(idAsString);
        try {
            jpaController.destroy(id);
            JsfUtil.addSuccessMessage("Cidade was successfully deleted.");
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

    public List<Cidade> getCidadeItems() {
        if (cidadeItems == null) {
            getPagingInfo();
            cidadeItems = jpaController.findCidadeEntities(pagingInfo.getBatchSize(), pagingInfo.getFirstItem());
        }
        return cidadeItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "cidade_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "cidade_list";
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
        cidade = null;
        cidadeItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Cidade newCidade = new Cidade();
        String newCidadeString = converter.getAsString(FacesContext.getCurrentInstance(), null, newCidade);
        String cidadeString = converter.getAsString(FacesContext.getCurrentInstance(), null, cidade);
        if (!newCidadeString.equals(cidadeString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }

}
