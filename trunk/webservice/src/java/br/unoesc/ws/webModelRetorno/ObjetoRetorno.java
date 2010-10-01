
package br.unoesc.ws.webModelRetorno;

/**classe que possui os dados do retorno sobre qualquer operacao do
 * webservice
 *
 * @author vitor
 */
public class ObjetoRetorno {

    private Long codigoRetorno;
    private String mensagemRetorno;
    private String descricaoCodRetornoAdicional;
    private String codigoRetornoAdicional;

    public ObjetoRetorno() {
    }

    public ObjetoRetorno(Long codigoRetorno, String mensagemRetorno,String descricaoCodRetornoAdicional, String codigoRetornoAdicional) {
        this.codigoRetorno = codigoRetorno;
        setMensagemRetorno(mensagemRetorno);
        setDescricaoCodRetornoAdicional(descricaoCodRetornoAdicional);
        this.codigoRetornoAdicional = codigoRetornoAdicional;
    }


    public Long getCodigoRetorno() {
        return codigoRetorno;
    }

    public void setCodigoRetorno(Long codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

    public String getCodigoRetornoAdicional() {
        return codigoRetornoAdicional;
    }

    public void setCodigoRetornoAdicional(String codigoRetornoAdicional) {
        this.codigoRetornoAdicional = codigoRetornoAdicional;
    }

    public String getMensagemRetorno() {
        return mensagemRetorno;
    }

    public void setMensagemRetorno(String mensagemRetorno) {
        this.mensagemRetorno = mensagemRetorno.toUpperCase();
    }

    public void setDescricaoCodRetornoAdicional(String descricaoCodRetornoAdicional) {
        this.descricaoCodRetornoAdicional = descricaoCodRetornoAdicional.toUpperCase();
    }

    public String getDescricaoCodRetornoAdicional() {
        return descricaoCodRetornoAdicional;
    }


}
