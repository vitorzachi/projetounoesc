package br.unoesc.ws.webModelEntrada;

/**
 *
 * @author vitor
 */
public class TransacaoCreditoModel {

    private Long codCereal;
    private Long codEmpresa;
    private String cpfProdutor;
    private Long numNotaFiscal;
    private Float qtdComprada;

    public TransacaoCreditoModel() {
    }

    public Long getCodCereal() {
        return codCereal;
    }

    public void setCodCereal(Long codCereal) {
        this.codCereal = codCereal;
    }

    public Long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public String getCpfProdutor() {
        return cpfProdutor;
    }

    public void setCpfProdutor(String cpfProdutor) {
        this.cpfProdutor = cpfProdutor;
    }

    public Long getNumNotaFiscal() {
        return numNotaFiscal;
    }

    public void setNumNotaFiscal(Long numNotaFiscal) {
        this.numNotaFiscal = numNotaFiscal;
    }

    public Float getQtdComprada() {
        return qtdComprada;
    }

    public void setQtdComprada(Float qtdComprada) {
        this.qtdComprada = qtdComprada;
    }

    
}
