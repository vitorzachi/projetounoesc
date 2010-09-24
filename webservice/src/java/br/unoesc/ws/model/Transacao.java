package br.unoesc.ws.model;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author vitor
 */
@Entity
public abstract class Transacao extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Long numeroNotaFiscal;
    @Column(length = 2)
    private String serieNotaFiscal;
    @ManyToOne
    private Produtor produtor;
    @ManyToOne
    private Empresa empresaGeradora;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dataTransacao;
    private Float quantidade;
    @ManyToOne
    private Cereal cereal;

    public Cereal getCereal() {
        return cereal;
    }

    public void setCereal(Cereal cereal) {
        this.cereal = cereal;
    }

    public Long getNumeroNotaFiscal() {
        return numeroNotaFiscal;
    }

    public String getSerieNotaFiscal() {
        return serieNotaFiscal;
    }

    public void setNumeroNotaFiscal(Long numeroNotaFiscal) {
        this.numeroNotaFiscal = numeroNotaFiscal;
    }

    public void setSerieNotaFiscal(String serieNotaFiscal) {
        this.serieNotaFiscal = serieNotaFiscal;
    }

    public Date getDataTransacao() {
        return dataTransacao;
    }

    public void setDataTransacao(Date data) {
        this.dataTransacao = data;
    }

    public Empresa getEmpresaGeradora() {
        return empresaGeradora;
    }

    public void setEmpresaGeradora(Empresa empresaGeradora) {
        this.empresaGeradora = empresaGeradora;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Produtor getProdutor() {
        return produtor;
    }

    public void setProdutor(Produtor produtor) {
        this.produtor = produtor;
    }

    public Float getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Float quantidade) {
        this.quantidade = quantidade;
    }
}
