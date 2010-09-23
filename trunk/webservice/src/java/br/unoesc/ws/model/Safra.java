/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unoesc.ws.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author vitor
 */
@Entity
public class Safra extends GenericModel{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String nome;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


}
