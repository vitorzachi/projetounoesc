
package br.unoesc.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;

/**
 *
 * @author vitor
 */
@Entity
public class Empresa extends Pessoa{

    @Column(nullable=false,unique=true)
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
