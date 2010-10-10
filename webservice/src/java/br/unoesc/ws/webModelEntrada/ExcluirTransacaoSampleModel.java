
package br.unoesc.ws.webModelEntrada;

/**
 *
 * @author vitor
 */
public class ExcluirTransacaoSampleModel {

    private String serieNotaFiscal;
    private Long numeroNotaFiscal;
    private Long idCereal;
    private Long codEmpresa;
    private String senha;

    public ExcluirTransacaoSampleModel() {
    }

    public ExcluirTransacaoSampleModel(String serieNotaFiscal, Long numeroNotaFiscal, Long codEmpresa, String senha, Long idCereal) {
        this.serieNotaFiscal = serieNotaFiscal.toUpperCase();
        this.numeroNotaFiscal = numeroNotaFiscal;
        this.codEmpresa = codEmpresa;
        this.senha = senha;
        this.idCereal=idCereal;
    }

    public Long getCodEmpresa() {
        return codEmpresa;
    }

    public void setCodEmpresa(Long codEmpresa) {
        this.codEmpresa = codEmpresa;
    }

    public Long getNumeroNotaFiscal() {
        return numeroNotaFiscal;
    }

    public void setNumeroNotaFiscal(Long numeroNotaFiscal) {
        this.numeroNotaFiscal = numeroNotaFiscal;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSerieNotaFiscal() {
        return serieNotaFiscal;
    }

    public void setSerieNotaFiscal(String serieNotaFiscal) {
        this.serieNotaFiscal = serieNotaFiscal;
    }

    public Long getIdCereal() {
        return idCereal;
    }

    public void setIdCereal(Long idCereal) {
        this.idCereal = idCereal;
    }


}
