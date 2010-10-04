/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unoesc.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 *
 * @author vitor
 */
@Entity
public class PrecoSafra extends GenericModel{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    @ManyToOne
    private Safra safra;
    @ManyToOne
    private Cereal cereal;

    private Float precoPorKgSemente;

    public PrecoSafra() {
    }

    public PrecoSafra(Long id, Safra safra, Cereal cereal, Float precoPorKgSemente) {
        this.id = id;
        this.safra = safra;
        this.cereal = cereal;
        this.precoPorKgSemente = precoPorKgSemente;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cereal getCereal() {
        return cereal;
    }

    public void setCereal(Cereal cereal) {
        this.cereal = cereal;
    }

    public Float getPrecoPorKgSemente() {
        return precoPorKgSemente;
    }

    public void setPrecoPorKgSemente(Float precoPorKgSemente) {
        this.precoPorKgSemente = precoPorKgSemente;
    }

    public Safra getSafra() {
        return safra;
    }

    public void setSafra(Safra safra) {
        this.safra = safra;
    }


}
