
package br.unoesc.ws.test.cereal;

import br.unoesc.ws.exceptions.CerealNotFoundException;
import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.Cereal;
import br.unoesc.ws.serviceModel.CerealServiceImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitor
 */
public class CerealTeste {

    @Test
    public void insereCereal(){
        CerealServiceImpl ci=new CerealServiceImpl();
        Cereal c=new Cereal();
        c.setNome("soja");
        try {
            ci.salvar(c);
            assertTrue(true);
        } catch (SalvarException ex) {
            fail(ex.getMessage());
        }
    }
    @Test
    public void insereCerea2l(){
        CerealServiceImpl ci=new CerealServiceImpl();
        Cereal c=new Cereal();
        c.setNome("milho");
        try {
            ci.salvar(c);
            assertTrue(true);
        } catch (SalvarException ex) {
            fail(ex.getMessage());
        }
    }

    @Test
    public void getCerealPorNomeTeste(){
        CerealServiceImpl ci=new CerealServiceImpl();
        Cereal c1=null;
        try {
            c1 = ci.getCerealPorNome("soja");
        } catch (CerealNotFoundException ex) {
            Logger.getLogger(CerealTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
        assertNotNull(c1);

    }
}
