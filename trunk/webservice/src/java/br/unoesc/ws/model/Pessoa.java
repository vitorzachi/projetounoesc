
package br.unoesc.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import org.apache.commons.lang.builder.CompareToBuilder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;
import org.apache.commons.lang.builder.ToStringStyle;

/**
 *
 * @author vitor
 */
@Entity
@Inheritance(strategy=InheritanceType.JOINED)
public abstract class Pessoa extends GenericModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable=false)
    private String nomePessoa;

    private String endereco;
    
    @ManyToOne
    private Cidade cidade;

    public Cidade getCidade() {
        return cidade;
    }

    public void setCidade(Cidade cidade) {
        this.cidade = cidade;
    }

    public Pessoa() {
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco.toUpperCase();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa.toUpperCase();
    }
 @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Pessoa outro = (Pessoa) obj;
        return new EqualsBuilder().append(this.getNomePessoa(), outro.getNomePessoa()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getNomePessoa()).hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append(this.getNomePessoa()).toString();
    }

    public int compareTo(Pessoa o) {
        return new CompareToBuilder().append(this.getNomePessoa(), o.getNomePessoa()).toComparison();
    }

}
