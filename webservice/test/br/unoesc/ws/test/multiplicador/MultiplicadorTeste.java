
package br.unoesc.ws.test.multiplicador;

import br.unoesc.ws.exceptions.CerealNotFoundException;
import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.MultiplicadorEstadoSafra;
import br.unoesc.ws.serviceModel.CerealServiceImpl;
import br.unoesc.ws.serviceModel.EstadoServiceImpl;
import br.unoesc.ws.serviceModel.MultiplicadorEstadoSafraServiceImpl;
import br.unoesc.ws.serviceModel.SafraServiceImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author vitor
 */
public class MultiplicadorTeste {

    @Test
    public void insereMultiplicador(){
        MultiplicadorEstadoSafra m=new MultiplicadorEstadoSafra();
        MultiplicadorEstadoSafraServiceImpl mi=new MultiplicadorEstadoSafraServiceImpl();
        EstadoServiceImpl e=new EstadoServiceImpl();
        SafraServiceImpl s=new SafraServiceImpl();
        m.setEstadoPlantio(e.getById(1l));
        try {
            m.setSafra(s.getSafraCorrente(new CerealServiceImpl().getCerealPorNome("soja")));
        } catch (CerealNotFoundException ex) {
            Logger.getLogger(MultiplicadorTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.setMultiplicador(new Long(60));

        try {
            mi.salvar(m);
        } catch (SalvarException ex) {
            Logger.getLogger(MultiplicadorTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void insereMultiplicador2(){
        MultiplicadorEstadoSafra m=new MultiplicadorEstadoSafra();
        MultiplicadorEstadoSafraServiceImpl mi=new MultiplicadorEstadoSafraServiceImpl();
        EstadoServiceImpl e=new EstadoServiceImpl();
        SafraServiceImpl s=new SafraServiceImpl();
        m.setEstadoPlantio(e.getById(2l));
        try {
            m.setSafra(s.getSafraCorrente(new CerealServiceImpl().getCerealPorNome("soja")));
        } catch (CerealNotFoundException ex) {
            Logger.getLogger(MultiplicadorTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
        m.setMultiplicador(new Long(70));

        try {
            mi.salvar(m);
        } catch (SalvarException ex) {
            Logger.getLogger(MultiplicadorTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
