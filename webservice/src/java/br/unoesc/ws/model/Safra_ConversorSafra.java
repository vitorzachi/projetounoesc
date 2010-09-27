
package br.unoesc.ws.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author vitor
 */
//@Entity
public class Safra_ConversorSafra {

//    @ManyToOne
    private Safra safra;
//    @ManyToOne
    private ConversorSafra conversorSafra;

    public Safra_ConversorSafra() {
    }

    public ConversorSafra getConversorSafra() {
        return conversorSafra;
    }

    public void setConversorSafra(ConversorSafra conversorSafra) {
        this.conversorSafra = conversorSafra;
    }

    public Safra getSafra() {
        return safra;
    }

    public void setSafra(Safra safra) {
        this.safra = safra;
    }


}
