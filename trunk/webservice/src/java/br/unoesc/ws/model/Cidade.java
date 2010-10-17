
package br.unoesc.ws.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
public class Cidade extends GenericModel{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @Column(nullable=false)
    private String nomeCidade;
    @ManyToOne
    private Estado estado;

    public Cidade() {
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomeCidade = nomeCidade;
    }

    @Override
    public boolean equals(Object obj){
     if(obj == null){
         return false;
     }
        Cidade outro=(Cidade)obj;
        return new EqualsBuilder()
                .append(this.getNomeCidade(),outro.getNomeCidade())
                .isEquals();
    }

 @Override
 public int hashCode(){
     return new HashCodeBuilder()
             .append(this.getNomeCidade())
             .hashCode();
 }

 @Override
 public String toString(){
     return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
             .append("Nome",this.getNomeCidade()).toString();
 }

 public int compareTo(Cidade o){
     return new CompareToBuilder()
             .append(this.getNomeCidade(),o.getNomeCidade())
             .toComparison();
 }

}
