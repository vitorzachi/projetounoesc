/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unoesc.ws.exceptions;

/**
 *
 * @author vitor
 */
public class CerealNotFoundException extends Exception{

    public CerealNotFoundException() {
        super("Não existe Cereal com esse código");
    }


}