package br.unoesc.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author leandro
 */
@Entity
public class Usuario extends GenericModel {

    @Column(nullable = false)
    private String usuario;
    @Column(nullable = false, unique=true)
    private String senha;
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    public Usuario() {
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

     @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Usuario outro = (Usuario) obj;
        return new EqualsBuilder().append(this.getUsuario(), outro.getUsuario()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getUsuario()).hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(this.getUsuario()).toString();
    }

    public int compareTo(Usuario o) {
        return new CompareToBuilder().append(this.getUsuario(), o.getUsuario()).toComparison();
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public Long getId() {
        return id;
    }
}
