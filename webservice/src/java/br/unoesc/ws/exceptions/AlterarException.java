package br.unoesc.ws.exceptions;

/**
 *
 * @author vitor
 */
public class AlterarException extends Exception {

    public AlterarException(String mensagem) {
        super(mensagem);
    }

    public AlterarException() {
        super("Erro ao alterar os dados!");
    }
}
