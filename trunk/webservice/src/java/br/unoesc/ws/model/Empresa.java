
package br.unoesc.ws.model;

import javax.persistence.Entity;

/**
 *
 * @author vitor
 */
@Entity
public class Empresa extends Pessoa{

    private String cnpj;

    public Empresa() {
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
}
