
package br.unoesc.ws.exceptions;

/**
 *
 * @author vitor
 */
public class CidadeNotFoundException extends Exception{

    public CidadeNotFoundException() {
        super("Não existe Cidade com este código.");
    }


}
