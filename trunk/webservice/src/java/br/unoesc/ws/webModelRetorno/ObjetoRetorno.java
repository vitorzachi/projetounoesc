
package br.unoesc.ws.webModelRetorno;

/**
 *
 * @author vitor
 */
public class ObjetoRetorno {

    private Long codigoRetorno;
    private String mensagemRetorno;
    private Long codigoRetornoAdicional;

    public ObjetoRetorno() {
    }

    public Long getCodigoRetorno() {
        return codigoRetorno;
    }

    public void setCodigoRetorno(Long codigoRetorno) {
        this.codigoRetorno = codigoRetorno;
    }

    public Long getCodigoRetornoAdicional() {
        return codigoRetornoAdicional;
    }

    public void setCodigoRetornoAdicional(Long codigoRetornoAdicional) {
        this.codigoRetornoAdicional = codigoRetornoAdicional;
    }

    public String getMensagemRetorno() {
        return mensagemRetorno;
    }

    public void setMensagemRetorno(String mensagemRetorno) {
        this.mensagemRetorno = mensagemRetorno;
    }


}
