
package br.unoesc.ws.exceptions;

/**
 *
 * @author vitor
 */
public class CerealNotFoundException extends Exception{

    public CerealNotFoundException() {
        super("Não existe cereal com esse código");
    }

    public CerealNotFoundException(String mensagem){
        super(mensagem);
    }

}
