
package br.unoesc.ws.exceptions;

/**
 *
 * @author vitor
 */
public class SafraJaExisteException extends SalvarException{

    public SafraJaExisteException() {
        super("Já existe uma safra cadastrada para esse período.");
    }
}
