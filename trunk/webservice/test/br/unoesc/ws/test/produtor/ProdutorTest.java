/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unoesc.ws.test.produtor;

import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.Produtor;
import br.unoesc.ws.serviceModel.ProdutorServiceImpl;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitor
 */
public class ProdutorTest {

    @Test
    public void insereProdutor() {
        Produtor p = new Produtor();
        p.setNomePessoa("vitor");
        p.setEndereco("linha");

        ProdutorServiceImpl pl = new ProdutorServiceImpl();
        try {
            pl.salvar(p);
            //p.setCidade(null);
        } catch (SalvarException ex) {
        }
        assertTrue(true);
    }
}
