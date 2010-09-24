
package br.unoesc.ws.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
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
public class Safra extends GenericModel{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nomeSafra;
    @Temporal(TemporalType.DATE)
    private Date inicioSafra;
    @Temporal(TemporalType.DATE)
    private Date fimSafra;

    public Safra() {
    }

    public Date getFimSafra() {
        return fimSafra;
    }

    public void setFimSafra(Date fimSafra) {
        this.fimSafra = fimSafra;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getInicioSafra() {
        return inicioSafra;
    }

    public void setInicioSafra(Date inicioSafra) {
        this.inicioSafra = inicioSafra;
    }

    public String getNomeSafra() {
        return nomeSafra;
    }

    public void setNomeSafra(String nome) {
        this.nomeSafra = nome;
    }

@Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        Safra outro = (Safra) obj;
        return new EqualsBuilder().append(this.getNomeSafra(), outro.getNomeSafra()).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(this.getNomeSafra()).hashCode();
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE).append("Nome", this.getNomeSafra()).toString();
    }

    public int compareTo(Safra o) {
        return new CompareToBuilder().append(this.getNomeSafra(), o.getNomeSafra()).toComparison();
    }


}
