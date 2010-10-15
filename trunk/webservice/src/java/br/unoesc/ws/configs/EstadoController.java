/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unoesc.ws.configs;

import br.unoesc.ws.configs.util.PagingInfo;
import br.unoesc.ws.model.Estado;
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
public class EstadoController {

    public EstadoController() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        jpaController = (EstadoJpaController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "estadoJpa");
        pagingInfo = new PagingInfo();
        converter = new EstadoConverter();
    }
    private Estado estado = null;
    private List<Estado> estadoItems = null;
    private EstadoJpaController jpaController = null;
    private EstadoConverter converter = null;
    private PagingInfo pagingInfo = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(jpaController.getEstadoCount());
        }
        return pagingInfo;
    }

    public SelectItem[] getEstadoItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(jpaController.findEstadoEntities(), false);
    }

    public SelectItem[] getEstadoItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(jpaController.findEstadoEntities(), true);
    }

    public Estado getEstado() {
        if (estado == null) {
            estado = (Estado) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentEstado", converter, null);
        }
        if (estado == null) {
            estado = new Estado();
        }
        return estado;
    }

    public String listSetup() {
        reset(true);
        return "estado_list";
    }

    public String createSetup() {
        reset(false);
        estado = new Estado();
        return "estado_create";
    }

    public String create() {
        try {
            jpaController.create(estado);
            JsfUtil.addSuccessMessage("Estado was successfully created.");
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("estado_detail");
    }

    public String editSetup() {
        return scalarSetup("estado_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        estado = (Estado) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentEstado", converter, null);
        if (estado == null) {
            String requestEstadoString = JsfUtil.getRequestParameter("jsfcrud.currentEstado");
            JsfUtil.addErrorMessage("The estado with id " + requestEstadoString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String estadoString = converter.getAsString(FacesContext.getCurrentInstance(), null, estado);
        String currentEstadoString = JsfUtil.getRequestParameter("jsfcrud.currentEstado");
        if (estadoString == null || estadoString.length() == 0 || !estadoString.equals(currentEstadoString)) {
            String outcome = editSetup();
            if ("estado_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit estado. Try again.");
            }
            return outcome;
        }
        try {
            jpaController.edit(estado);
            JsfUtil.addSuccessMessage("Estado was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentEstado");
        Long id = new Long(idAsString);
        try {
            jpaController.destroy(id);
            JsfUtil.addSuccessMessage("Estado was successfully deleted.");
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

    public List<Estado> getEstadoItems() {
        if (estadoItems == null) {
            getPagingInfo();
            estadoItems = jpaController.findEstadoEntities(pagingInfo.getBatchSize(), pagingInfo.getFirstItem());
        }
        return estadoItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "estado_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "estado_list";
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
        estado = null;
        estadoItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Estado newEstado = new Estado();
        String newEstadoString = converter.getAsString(FacesContext.getCurrentInstance(), null, newEstado);
        String estadoString = converter.getAsString(FacesContext.getCurrentInstance(), null, estado);
        if (!newEstadoString.equals(estadoString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }

}
