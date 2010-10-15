/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unoesc.ws.configs;

import br.unoesc.ws.configs.util.PagingInfo;
import br.unoesc.ws.model.Produtor;
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
public class ProdutorController1 {

    public ProdutorController1() {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        jpaController = (ProdutorJpaController) facesContext.getApplication().getELResolver().getValue(facesContext.getELContext(), null, "produtorJpa");
        pagingInfo = new PagingInfo();
        converter = new ProdutorConverter();
    }
    private Produtor produtor = null;
    private List<Produtor> produtorItems = null;
    private ProdutorJpaController jpaController = null;
    private ProdutorConverter converter = null;
    private PagingInfo pagingInfo = null;

    public PagingInfo getPagingInfo() {
        if (pagingInfo.getItemCount() == -1) {
            pagingInfo.setItemCount(jpaController.getProdutorCount());
        }
        return pagingInfo;
    }

    public SelectItem[] getProdutorItemsAvailableSelectMany() {
        return JsfUtil.getSelectItems(jpaController.findProdutorEntities(), false);
    }

    public SelectItem[] getProdutorItemsAvailableSelectOne() {
        return JsfUtil.getSelectItems(jpaController.findProdutorEntities(), true);
    }

    public Produtor getProdutor() {
        if (produtor == null) {
            produtor = (Produtor) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentProdutor", converter, null);
        }
        if (produtor == null) {
            produtor = new Produtor();
        }
        return produtor;
    }

    public String listSetup() {
        reset(true);
        return "produtor_list";
    }

    public String createSetup() {
        reset(false);
        produtor = new Produtor();
        return "produtor_create";
    }

    public String create() {
        try {
            jpaController.create(produtor);
            JsfUtil.addSuccessMessage("Produtor was successfully created.");
        } catch (Exception e) {
            JsfUtil.ensureAddErrorMessage(e, "A persistence error occurred.");
            return null;
        }
        return listSetup();
    }

    public String detailSetup() {
        return scalarSetup("produtor_detail");
    }

    public String editSetup() {
        return scalarSetup("produtor_edit");
    }

    private String scalarSetup(String destination) {
        reset(false);
        produtor = (Produtor) JsfUtil.getObjectFromRequestParameter("jsfcrud.currentProdutor", converter, null);
        if (produtor == null) {
            String requestProdutorString = JsfUtil.getRequestParameter("jsfcrud.currentProdutor");
            JsfUtil.addErrorMessage("The produtor with id " + requestProdutorString + " no longer exists.");
            return relatedOrListOutcome();
        }
        return destination;
    }

    public String edit() {
        String produtorString = converter.getAsString(FacesContext.getCurrentInstance(), null, produtor);
        String currentProdutorString = JsfUtil.getRequestParameter("jsfcrud.currentProdutor");
        if (produtorString == null || produtorString.length() == 0 || !produtorString.equals(currentProdutorString)) {
            String outcome = editSetup();
            if ("produtor_edit".equals(outcome)) {
                JsfUtil.addErrorMessage("Could not edit produtor. Try again.");
            }
            return outcome;
        }
        try {
            jpaController.edit(produtor);
            JsfUtil.addSuccessMessage("Produtor was successfully updated.");
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
        String idAsString = JsfUtil.getRequestParameter("jsfcrud.currentProdutor");
        Long id = new Long(idAsString);
        try {
            jpaController.destroy(id);
            JsfUtil.addSuccessMessage("Produtor was successfully deleted.");
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

    public List<Produtor> getProdutorItems() {
        if (produtorItems == null) {
            getPagingInfo();
            produtorItems = jpaController.findProdutorEntities(pagingInfo.getBatchSize(), pagingInfo.getFirstItem());
        }
        return produtorItems;
    }

    public String next() {
        reset(false);
        getPagingInfo().nextPage();
        return "produtor_list";
    }

    public String prev() {
        reset(false);
        getPagingInfo().previousPage();
        return "produtor_list";
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
        produtor = null;
        produtorItems = null;
        pagingInfo.setItemCount(-1);
        if (resetFirstItem) {
            pagingInfo.setFirstItem(0);
        }
    }

    public void validateCreate(FacesContext facesContext, UIComponent component, Object value) {
        Produtor newProdutor = new Produtor();
        String newProdutorString = converter.getAsString(FacesContext.getCurrentInstance(), null, newProdutor);
        String produtorString = converter.getAsString(FacesContext.getCurrentInstance(), null, produtor);
        if (!newProdutorString.equals(produtorString)) {
            createSetup();
        }
    }

    public Converter getConverter() {
        return converter;
    }

}
