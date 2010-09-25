
package br.unoesc.ws.test.produtor;

import br.unoesc.ws.exceptions.AlterarException;
import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.Cidade;
import br.unoesc.ws.serviceModel.CidadeServiceImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
/**
 *
 * @author leandro
 */

public class CidadeServiceImplTest {

/* @Test
    public void testGetEntityManager() {
        CidadeServiceImpl cidadeServiceImpl=new CidadeServiceImpl();
        assertNotNull(cidadeServiceImpl.getEntityManager());
    }*/

    @Test
    public void testSaveCidade() {
        CidadeServiceImpl cidadeServiceImpl=new CidadeServiceImpl();
        Cidade cidade = new Cidade();
        cidade.setNomeCidade("Curitiba");
        try {
            cidadeServiceImpl.salvar(cidade);
        } catch (SalvarException ex) {
            Logger.getLogger(CidadeServiceImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testAlterarCidade() {
        try {
            CidadeServiceImpl cidadeServiceImpl = new CidadeServiceImpl();
            Cidade cidade = new Cidade();
            cidade.setNomeCidade("Florianópolis");
            try {
                cidadeServiceImpl.salvar(cidade);
            } catch (SalvarException ex) {
                Logger.getLogger(CidadeServiceImplTest.class.getName()).log(Level.SEVERE, null, ex);
            }
            cidade.setNomeCidade("novo nome");
            cidadeServiceImpl.alterar(cidade);
            assertEquals(cidade.getNomeCidade(), "novo nome");
        } catch (AlterarException ex) {
            Logger.getLogger(CidadeServiceImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Test
    public void testExcluirCidade() {
        CidadeServiceImpl cidadeServiceImpl=new CidadeServiceImpl();
        Cidade cidade = new Cidade();
        cidade.setNomeCidade("Curitiba");
        try {
            cidadeServiceImpl.salvar(cidade);
        } catch (SalvarException ex) {
            Logger.getLogger(CidadeServiceImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        cidadeServiceImpl.excluir(cidade.getId());
    }

    @Test
    public void testGetCidade() {
         CidadeServiceImpl cidadeServiceImpl=new CidadeServiceImpl();
        Cidade cidade = new Cidade();
        cidade.setNomeCidade("Teste Get");
        try {
            cidadeServiceImpl.salvar(cidade);
        } catch (SalvarException ex) {
            Logger.getLogger(CidadeServiceImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        Cidade c = (Cidade) new CidadeServiceImpl().getById(cidade.getId());
        assertNotNull(c);
    }

  /*  @Test
    public void testGetCidades() {
        CidadeServiceImpl cidadeServiceImpl=new CidadeServiceImpl();
        Cidade cidade = new Cidade();
        cidade.setNomeCidade("Teste Get");
        try {
            cidadeServiceImpl.salvar(cidade);
        } catch (SalvarException ex) {
            Logger.getLogger(CidadeServiceImplTest.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Cidade> cidades = cidadeServiceImpl.getAll();
        boolean achou = false;
        for (Cidade cid : cidades) {
            if (cid.getNomeCidade().equals(cidade.getNomeCidade())) {
                assertTrue(true);
                achou = true;
                break;
            }
        }
        if (!achou) {
            fail("Não achou!");
        }
    }

   */

}
