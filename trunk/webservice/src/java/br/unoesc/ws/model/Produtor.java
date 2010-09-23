
package br.unoesc.ws.model;

import javax.persistence.Entity;

/**
 *
 * @author vitor
 */
@Entity
public class Produtor extends Pessoa{

    private String cpf;

    public Produtor() {
    }


    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }


}
