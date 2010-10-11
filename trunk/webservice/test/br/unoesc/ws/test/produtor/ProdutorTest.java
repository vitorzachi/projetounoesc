package br.unoesc.ws.test.produtor;

import br.unoesc.ws.exceptions.CerealNotFoundException;
import br.unoesc.ws.exceptions.ProdutorNotFoundException;
import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.Produtor;
import br.unoesc.ws.serviceModel.CerealServiceImpl;
import br.unoesc.ws.serviceModel.EstadoServiceImpl;
import br.unoesc.ws.serviceModel.ProdutorServiceImpl;
import br.unoesc.ws.serviceModel.SafraServiceImpl;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitor
 */
public class ProdutorTest {

//    @Test
    public void insereProdutor() {
        Produtor p = new Produtor();
        p.setNomePessoa("vitor");
        p.setEndereco("linha");
        p.setCpf("05456216900");

        ProdutorServiceImpl pl = new ProdutorServiceImpl();
        try {
            pl.salvar(p);
            assertTrue(true);
            //p.setCidade(null);
        } catch (SalvarException ex) {
            fail(ex.getMessage());
        }

    }

//    @Test
    public void getProdutorByCPF() {
        Produtor p = new Produtor();
        p.setNomePessoa("vitor");
        p.setEndereco("linha");
        p.setCpf("05456216901");

        Produtor p1 = null;

        ProdutorServiceImpl pl = new ProdutorServiceImpl();
        try {
            pl.salvar(p);
            p1 = pl.getByCPF("05456216901");
            System.out.println(p1.getNomePessoa());
            assertTrue(true);
            //p.setCidade(null);
        } catch (Exception ex) {
            fail(ex.getMessage());
        }

    }

    @Test
    public void getSaldoProdutorTeste() {
        Long saldo=null;

        ProdutorServiceImpl pi = new ProdutorServiceImpl();
        SafraServiceImpl si=new SafraServiceImpl();
        CerealServiceImpl ci=new CerealServiceImpl();
        EstadoServiceImpl e=new EstadoServiceImpl();

        Produtor p = null;
        try {
            p = pi.getByCPF("05456216900");
        } catch (ProdutorNotFoundException ex) {
            fail(ex.getMessage());
        }

        try {
            saldo=pi.getSaldoRoyalties(p, si.getSafraCorrente(ci.getCerealPorNome("soja")));
        } catch (CerealNotFoundException ex) {
            fail(ex.getMessage());
        }

        System.out.println(saldo);
        assertNotNull(saldo);
    }
}
