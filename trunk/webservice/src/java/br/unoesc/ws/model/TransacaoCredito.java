
package br.unoesc.ws.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

/**
 *
 * @author vitor
 */
@Entity
public class TransacaoCredito extends Transacao{

    @OneToOne(cascade=CascadeType.ALL)
    private Boleto boletoGerado;

    public TransacaoCredito() {
    }

    public Boleto getBoletoGerado() {
        return boletoGerado;
    }

    public void setBoletoGerado(Boleto boletoGerado) {
        this.boletoGerado = boletoGerado;
    }


    
}
