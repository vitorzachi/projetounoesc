/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unoesc.ws.test.estado;

import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.Estado;
import br.unoesc.ws.serviceModel.EstadoServiceImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;


/**
 *
 * @author vitor
 */
public class EstadoTeste {

    @Test
    public void insereEstadoTeste(){
        Estado e=new Estado();
        EstadoServiceImpl ie=new EstadoServiceImpl();

        e.setNomeEstado("santa catarina");
        e.setSiglaEstado("sc");
        try {
            ie.salvar(e);
        } catch (SalvarException ex) {
            Logger.getLogger(EstadoTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
     @Test
    public void insereEstadoTeste2(){
        Estado e=new Estado();
        EstadoServiceImpl ie=new EstadoServiceImpl();

        e.setNomeEstado("paraná");
        e.setSiglaEstado("pr");
        try {
            ie.salvar(e);
        } catch (SalvarException ex) {
            Logger.getLogger(EstadoTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
