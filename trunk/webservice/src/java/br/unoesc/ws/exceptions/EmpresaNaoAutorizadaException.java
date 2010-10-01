
package br.unoesc.ws.exceptions;

/**
 *
 * @author vitor
 */
public class EmpresaNaoAutorizadaException extends Exception{

    public EmpresaNaoAutorizadaException() {
        super("não existe empresa cadastrada com este código!");
    }
}
