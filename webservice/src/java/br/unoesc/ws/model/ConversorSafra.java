/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unoesc.ws.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

/**
 *
 * @author vitor
 */
@Entity
public class ConversorSafra extends GenericModel{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private Integer multiplicador;
    @ManyToOne
    private Cereal cereal;
//    @ManyToMany
    @Transient
    private Safra safraValida;

    public ConversorSafra() {
    }

    public Long getId() {
        return id;
    }

    public Cereal getCereal() {
        return cereal;
    }

    public void setCereal(Cereal cereal) {
        this.cereal = cereal;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getMultiplicador() {
        return multiplicador;
    }

    public void setMultiplicador(Integer multiplicador) {
        this.multiplicador = multiplicador;
    }

    public Safra getSafraValida() {
        return safraValida;
    }

    public void setSafraValida(Safra safraValida) {
        this.safraValida = safraValida;
    }


}
