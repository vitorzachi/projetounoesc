
package br.unoesc.ws.exceptions;

/**
 *
 * @author vitor
 */
public class TransacaoNotFoundException extends Exception{

    public TransacaoNotFoundException() {
        super("Transação não encontrada.");
    }


}
