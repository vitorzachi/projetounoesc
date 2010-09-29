
package br.unoesc.ws.test.safra;

import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.Safra;
import br.unoesc.ws.serviceModel.SafraServiceImpl;
import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitor
 */
public class SafraTest {

    @Test
    public void insereSafraTeste(){
        Safra s=new Safra();
        SafraServiceImpl si=new SafraServiceImpl();
        s.setFimSafra(new Date());
        s.setInicioSafra(new Date());
        s.setMultiplicadorCredito(new Long(70));
        s.setNomeSafra();

        try {
            si.salvar(s);
            assertTrue(true);
        } catch (SalvarException ex) {
            fail(ex.getMessage());
        }
    }
}
