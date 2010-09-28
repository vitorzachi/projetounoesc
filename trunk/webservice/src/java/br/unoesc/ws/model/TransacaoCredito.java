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

    @ManyToOne
    private Produtor produtor;
    @ManyToOne
    private Empresa empresaGeradora;
    @OneToOne(cascade = CascadeType.ALL)
    private Boleto boletoGerado;

    public TransacaoCredito() {
    }

    public Boleto getBoletoGerado() {
        return boletoGerado;
    }

    public void setBoletoGerado(Boleto boletoGerado) {
        this.boletoGerado = boletoGerado;
    }

    public Empresa getEmpresaGeradora() {
        return empresaGeradora;
    }

    public void setEmpresaGeradora(Empresa empresaGeradora) {
        this.empresaGeradora = empresaGeradora;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }
}
