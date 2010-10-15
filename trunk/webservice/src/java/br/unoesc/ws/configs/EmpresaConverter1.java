/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unoesc.ws.configs;

import br.unoesc.ws.model.Empresa;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;

/**
 *
 * @author leandro
 */
public class EmpresaConverter1 implements Converter {

    public Object getAsObject(FacesContext facesContext, UIComponent component, String string) {
        if (string == null || string.length() == 0) {
            return null;
        }
        Long id = new Long(string);
        EmpresaJpaController controller = (EmpresaJpaController) facesContext.getApplication().getVariableResolver().resolveVariable(facesContext, "empresaJpa");
        return controller.findEmpresa(id);
    }

    public String getAsString(FacesContext facesContext, UIComponent component, Object object) {
        if (object == null) {
            return null;
        }
        if (object instanceof Empresa) {
            Empresa o = (Empresa) object;
            return o.getId() == null ? "" : o.getId().toString();
        } else {
            throw new IllegalArgumentException("object " + object + " is of type " + object.getClass().getName() + "; expected type: br.unoesc.ws.model.Empresa");
        }
    }

}
