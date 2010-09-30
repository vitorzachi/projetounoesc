
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
    private String usuario;
    private String senha;

    public Empresa() {
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    
}
