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
        EstadoServiceImpl e=new EstadoServiceImpl();


        try {
            s.setFimSafra(Validacoes.adicionaDiasEmData(new Date(), 359));
            s.setInicioSafra(new Date());
            s.setCereal(c.getCerealPorNome("soja"));
            s.setEstadoPlantio(e.getById(1l));
            s.setMultiplicadorCredito(new Long(70));
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
    public void insereSafra2Teste() {
        Safra s = new Safra();
        SafraServiceImpl si = new SafraServiceImpl();
        CerealServiceImpl c = new CerealServiceImpl();


        try {
            s.setFimSafra(new Date());
            s.setInicioSafra(new Date());
            s.setCereal(c.getCerealPorNome("soja"));
            s.setMultiplicadorCredito(new Long(70));
            s.setNomeSafra();
            si.salvar(s);
            fail("falha no teste 2. nao pode inserir");
        } catch (SalvarException ex) {
            assertTrue(true);
        }catch (CerealNotFoundException ex){
            fail(ex.getMessage()+ " no teste 2");
        }
    }

    @Test
    public void getSafraTest(){
        Safra s=null;
        CerealServiceImpl c = new CerealServiceImpl();
        EstadoServiceImpl e=new EstadoServiceImpl();
        SafraServiceImpl si=new SafraServiceImpl();
        try {
            s = si.getSafraCorrente(c.getCerealPorNome("soja"),e.getById(1l));
        } catch (CerealNotFoundException ex) {
            Logger.getLogger(SafraTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(s.getNomeSafra());
        assertNotNull(s);
    }
}
