package br.unoesc.ws.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

/**
 *
 * @author vitor
 */
@Entity
public class TransacaoCredito extends Transacao {

    @OneToOne(cascade = CascadeType.ALL)
    private Boleto boletoGerado;
    @ManyToOne
    private Estado estadoPlantio;

    public TransacaoCredito() {
    }

    public Estado getEstadoPlantio() {
        return estadoPlantio;
    }

    public void setEstadoPlantio(Estado estadoPlantio) {
        this.estadoPlantio = estadoPlantio;
    }

    public Boleto getBoletoGerado() {
        return boletoGerado;
    }

    public void setBoletoGerado(Boleto boletoGerado) {
        this.boletoGerado = boletoGerado;
    }
}
