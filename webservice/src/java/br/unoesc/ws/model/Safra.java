package br.unoesc.ws.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
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
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"nomeSafra","estadoPlantio_id","cereal_id"})})
public class Safra extends GenericModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false)
    private String nomeSafra;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date inicioSafra;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date fimSafra;
    @ManyToOne
    private Cereal cereal;
    @ManyToOne
    private Estado estadoPlantio;
    @Column(nullable = false)
    private Long multiplicadorCredito;

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

//    public void setNomeSafra(String nome) {
//        this.nomeSafra = nome;
//    }

    public void setNomeSafra() {
        this.nomeSafra = new SimpleDateFormat("yyyy").format(inicioSafra) + "/" + new SimpleDateFormat("yyyy").format(fimSafra);
    }

    public Cereal getCereal() {
        return cereal;
    }

    public void setCereal(Cereal cereal) {
        this.cereal = cereal;
    }

    public Long getMultiplicadorCredito() {
        return multiplicadorCredito;
    }

    public Estado getEstadoPlantio() {
        return estadoPlantio;
    }

    public void setEstadoPlantio(Estado estadoPlantio) {
        this.estadoPlantio = estadoPlantio;
    }


    public void setMultiplicadorCredito(Long multiplicadorCredito) {
        this.multiplicadorCredito = multiplicadorCredito;
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
        return new ToStringBuilder(this, ToStringStyle.SIMPLE_STYLE).append(this.getNomeSafra()).toString();
    }

    public int compareTo(Safra o) {
        return new CompareToBuilder().append(this.getNomeSafra(), o.getNomeSafra()).toComparison();
    }
}
