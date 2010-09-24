
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
 * @author vitor
 */
@Entity
public class Estado extends GenericModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    private String nomeEstado;
    @Column( length=2)
    private String siglaEstado;

    public Estado() {
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomeEstado() {
        return nomeEstado;
    }

    public void setNomeEstado(String nomeEstado) {
        this.nomeEstado = nomeEstado.toUpperCase();
    }

    public String getSiglaEstado() {
        return siglaEstado;
    }

    public void setSiglaEstado(String siglaEstado) {
        this.siglaEstado = siglaEstado.toUpperCase();
    }


 @Override
    public boolean equals(Object obj){
     if(obj == null){
         return false;
     }
        Estado outro=(Estado)obj;
        return new EqualsBuilder()
                .append(this.getNomeEstado(),outro.getNomeEstado())
                .isEquals();
    }

 @Override
 public int hashCode(){
     return new HashCodeBuilder()
             .append(this.getNomeEstado())
             .hashCode();
 }

 @Override
 public String toString(){
     return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
             .append("Nome",this.getNomeEstado()).toString();
 }

 public int compareTo(Estado o){
     return new CompareToBuilder()
             .append(this.getNomeEstado(),o.getNomeEstado())
             .toComparison();
 }
}
