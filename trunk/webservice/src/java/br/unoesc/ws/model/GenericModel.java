
package br.unoesc.ws.model;

import br.unoesc.ws.webService.Property;
import java.io.Serializable;

/**
 *
 * @author vitor
 */
public abstract class GenericModel extends Property implements Serializable{

    public GenericModel() {
    }

    
    public abstract Long getId();
    
}
