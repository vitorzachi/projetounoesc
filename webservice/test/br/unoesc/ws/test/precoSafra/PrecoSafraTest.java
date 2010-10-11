
package br.unoesc.ws.test.precoSafra;

import br.unoesc.ws.model.PrecoSafra;
import br.unoesc.ws.serviceModel.CerealServiceImpl;
import br.unoesc.ws.serviceModel.EstadoServiceImpl;
import br.unoesc.ws.serviceModel.PrecoSafraServiceImpl;
import br.unoesc.ws.serviceModel.SafraServiceImpl;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitor
 */
public class PrecoSafraTest {

    @Test
    public void inserePreco(){
        try {
            PrecoSafra ps = new PrecoSafra();
            PrecoSafraServiceImpl psi = new PrecoSafraServiceImpl();
            EstadoServiceImpl e=new EstadoServiceImpl();
            CerealServiceImpl c = new CerealServiceImpl();
            SafraServiceImpl s = new SafraServiceImpl();

            ps.setCereal(c.getCerealPorNome("soja"));
            ps.setSafra(s.getSafraCorrente(c.getCerealPorNome("soja")));
            ps.setPrecoPorKgSemente(new Float(0.7f));
            psi.salvar(ps);
            assertTrue(true);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }
    }
//    @Test
//    public void inserePreco2(){
//        try {
//            PrecoSafra ps = new PrecoSafra();
//            PrecoSafraServiceImpl psi = new PrecoSafraServiceImpl();
//            EstadoServiceImpl e=new EstadoServiceImpl();
//            CerealServiceImpl c = new CerealServiceImpl();
//            SafraServiceImpl s = new SafraServiceImpl();
//
//            ps.setCereal(c.getCerealPorNome("soja"));
//            ps.setSafra(s.getSafraCorrente(c.getCerealPorNome("soja")));
//            ps.setPrecoPorKgSemente(new Float(0.8f));
//            psi.salvar(ps);
//            assertTrue(true);
//        } catch (Exception ex) {
//            fail(ex.getMessage());
//        }
//    }
}
