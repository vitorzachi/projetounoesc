package br.unoesc.ws.webModelEntrada;

/**classe utilizada para entrada de parametros dos metodos de transacao de credito.
 *recebe as chaves de pesquisa dos parametros contidos na classe de transacao
 * de credito e mais outras informacoes necessarias para sua validacao
 * 
 * @author vitor
 */
public class TransacaoSampleModel {

    private Long codCereal;
    private Long codEmpresa;
    private String cpfProdutor, serieNotaFiscal;
    private Long numNotaFiscal;
    private Integer quantidade;
    private String senha;

    public TransacaoSampleModel() {
    }

    public TransacaoSampleModel(Long codCereal, Long codEmpresa, String cpfProdutor, String serieNotaFiscal, Long numNotaFiscal, Integer quantidade, String senha) {
        this.codCereal = codCereal;
        this.codEmpresa = codEmpresa;
        this.cpfProdutor = cpfProdutor;
        setSerieNotaFiscal(serieNotaFiscal);
        this.numNotaFiscal = numNotaFiscal;
        this.quantidade = quantidade;
        this.senha = senha;
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

    public Integer getQtdComprada() {
        return quantidade;
    }

    public void setQtdComprada(Integer qtdComprada) {
        this.quantidade = qtdComprada;
    }

    public String getSerieNotaFiscal() {
        return serieNotaFiscal;
    }

    public void setSerieNotaFiscal(String serieNotaFiscal) {
        this.serieNotaFiscal = serieNotaFiscal.toUpperCase();
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
