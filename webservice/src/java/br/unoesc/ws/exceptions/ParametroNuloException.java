
package br.unoesc.ws.exceptions;

/**
 *
 * @author vitor
 */
public class ParametroNuloException extends Exception {

    public ParametroNuloException() {
    }

    public ParametroNuloException(String nomeParametro) {
        super("Parâmetro \""+nomeParametro+"\" não pode ser nulo ou ter valor \"zero\"(0)");
    }
}
