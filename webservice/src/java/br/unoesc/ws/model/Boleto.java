
package br.unoesc.ws.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

/**
 *
 * @author vitor
 */
@Entity
public class Boleto extends GenericModel{
    @Id
    private Long id;
    @OneToOne(cascade=CascadeType.ALL)
    private TransacaoCredito transacaoCredito;
    private boolean pago;

    public Boleto() {
    }

    public boolean isPago() {
        return pago;
    }

    public void setPago(boolean pago) {
        this.pago = pago;
    }

    public TransacaoCredito getTransacaoCredito() {
        return transacaoCredito;
    }

    public void setTransacaoCredito(TransacaoCredito transacaoCredito) {
        this.transacaoCredito = transacaoCredito;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }


}
