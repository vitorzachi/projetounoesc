/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unoesc.ws.exceptions;

/**
 *
 * @author vitor
 */
public class ProdutorNotFoundException extends Exception{

    public ProdutorNotFoundException(String mensagem) {
        super(mensagem);
    }

    public ProdutorNotFoundException() {
        super("Não existe Produtor cadastrado com este CPF");
    }
}
