

package br.unoesc.ws.exceptions;

/**
 *
 * @author vitor
 */
public class SalvarException extends Exception{

    public SalvarException(String mensagem) {
        super(mensagem);
    }

    public SalvarException() {
        super("Erro ao salvar os dados!");
    }

}
