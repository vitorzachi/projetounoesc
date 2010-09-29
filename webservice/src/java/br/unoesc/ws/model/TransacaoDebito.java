package br.unoesc.ws.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

/**
 *
 * @author vitor
 */
@Entity
public class TransacaoDebito extends Transacao{

    @ManyToOne
    private Produtor produtor;
    @ManyToOne
    private Empresa empresaGeradora;

    public TransacaoDebito() {
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public Empresa getEmpresaGeradora() {
        return empresaGeradora;
    }

    public void setEmpresaGeradora(Empresa empresaGeradora) {
        this.empresaGeradora = empresaGeradora;
    }
}
