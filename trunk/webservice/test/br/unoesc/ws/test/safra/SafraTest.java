package br.unoesc.ws.test.safra;

import br.unoesc.ws.exceptions.CerealNotFoundException;
import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.Safra;
import br.unoesc.ws.serviceModel.CerealServiceImpl;
import br.unoesc.ws.serviceModel.EstadoServiceImpl;
import br.unoesc.ws.serviceModel.SafraServiceImpl;
import br.unoesc.ws.util.Validacoes;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitor
 */
public class SafraTest {

    @Test
    public void insereSafraTeste() {
        Safra s = new Safra();
        SafraServiceImpl si = new SafraServiceImpl();
        CerealServiceImpl c = new CerealServiceImpl();


        try {
            s.setFimSafra(Validacoes.adicionaDiasEmData(new Date(), 359));
            s.setInicioSafra(new Date());
            s.setCereal(c.getCerealPorNome("soja"));
            s.setNomeSafra();
            si.salvar(s);
            assertTrue(true);
        } catch (SalvarException ex) {
            fail(ex.getMessage());
        }catch (CerealNotFoundException ex){
            fail(ex.getMessage());
        }
    }

    @Test
    public void insereSafraTeste2() {
        Safra s = new Safra();
        SafraServiceImpl si = new SafraServiceImpl();
        CerealServiceImpl c = new CerealServiceImpl();

        try {
            s.setFimSafra(Validacoes.adicionaDiasEmData(new Date(), 359));
            s.setInicioSafra(new Date());
            s.setCereal(c.getCerealPorNome("milho"));
            s.setNomeSafra();
            si.salvar(s);
            assertTrue(true);
        } catch (SalvarException ex) {
            fail(ex.getMessage());
        }catch (CerealNotFoundException ex){
            fail(ex.getMessage());
        }
    }

    @Test
    public void getSafraTest(){
        Safra s=null;
        CerealServiceImpl c = new CerealServiceImpl();
        EstadoServiceImpl e=new EstadoServiceImpl();
        SafraServiceImpl si=new SafraServiceImpl();
        try {
            s = si.getSafraCorrente(c.getCerealPorNome("soja"));
        } catch (CerealNotFoundException ex) {
            Logger.getLogger(SafraTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(s.getNomeSafra());
        assertNotNull(s);
    }
}
