
package br.unoesc.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 *
 * @author vitor
 */
@Entity
@Table(uniqueConstraints={@UniqueConstraint(columnNames={"estadoPlantio_id","safra_id"})})
public class MultiplicadorEstadoSafra extends GenericModel {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Estado estadoPlantio;
    @ManyToOne
    private Safra safra;
    private Long multiplicador;

    public MultiplicadorEstadoSafra() {
    }

    public Estado getEstadoPlantio() {
        return estadoPlantio;
    }

    public void setEstadoPlantio(Estado estadoPlantio) {
        this.estadoPlantio = estadoPlantio;
    }

    public Long getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(Long multiplicador) {
        this.multiplicador = multiplicador;
    }

    public Safra getSafra() {
        return safra;
    }

    public void setSafra(Safra safra) {
        this.safra = safra;
    }

    @Override
    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
