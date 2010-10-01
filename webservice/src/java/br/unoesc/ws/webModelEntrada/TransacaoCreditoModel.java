package br.unoesc.ws.webModelEntrada;

/**classe utilizada para entrada de parametros dos metodos de transacao de credito.
 *recebe as chaves de pesquisa dos parametros contidos na classe de transacao
 * de credito e mais outras informacoes necessarias para sua validacao
 * 
 * @author vitor
 */
public class TransacaoCreditoModel {

    private Long codCereal;
    private Long codEmpresa;
    private String cpfProdutor, serieNotaFiscal;
    private Long numNotaFiscal;
    private Float qtdComprada;
    private String senha;

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

    public String getSerieNotaFiscal() {
        return serieNotaFiscal;
    }

    public void setSerieNotaFiscal(String serieNotaFiscal) {
        this.serieNotaFiscal = serieNotaFiscal;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
