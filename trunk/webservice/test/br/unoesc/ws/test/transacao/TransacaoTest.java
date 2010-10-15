package br.unoesc.ws.test.transacao;

import br.unoesc.ws.exceptions.TransacaoNotFoundException;
import br.unoesc.ws.model.TransacaoDebito;
import br.unoesc.ws.serviceModel.TransacaoDebitoServiceImpl;
import br.unoesc.ws.webModelEntrada.IncluirTransacaoSampleModel;
import br.unoesc.ws.webModelRetorno.ObjetoRetorno;
import br.unoesc.ws.webServiceMethods.TransacaoWS;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitor
 */
public class TransacaoTest {

//    @Test
    public void insereTransacaoCredito() {

        IncluirTransacaoSampleModel tm = new IncluirTransacaoSampleModel(1l, 2l, "05456216900", "1", new Long(2369), 250, 1l, "pass");
        TransacaoWS tws = new TransacaoWS();
        ObjetoRetorno o = tws.incluirCredito(tm);
        System.out.println(o.getCodigoRetorno());
        System.out.println(o.getMensagemRetorno());

        System.out.println(o.getDescricaoCodRetornoAdicional());
        System.out.println(o.getCodigoRetornoAdicional());
        assertTrue(true);
    }

//    @Test
    public void insereTransacaoCredito2() {

        IncluirTransacaoSampleModel tm = new IncluirTransacaoSampleModel(1l, 3l, "05456216900", "1", new Long(2369), 10, 2l, "pass");
        TransacaoWS tws = new TransacaoWS();
        ObjetoRetorno o = tws.incluirCredito(tm);
        System.out.println(o.getCodigoRetorno());
        System.out.println(o.getMensagemRetorno());

        System.out.println(o.getDescricaoCodRetornoAdicional());
        System.out.println(o.getCodigoRetornoAdicional());
        assertTrue(true);
    }

//    @Test
    public void insereTransacaoDebito() {

        IncluirTransacaoSampleModel tm = new IncluirTransacaoSampleModel(1l, 2l, "05456216900", "1", new Long(2354), 100, 1l, "pass");
        TransacaoWS tws = new TransacaoWS();
        ObjetoRetorno o = tws.incluirDebito(tm);
        System.out.println(o.getCodigoRetorno());
        System.out.println(o.getMensagemRetorno());

        System.out.println(o.getDescricaoCodRetornoAdicional());
        System.out.println(o.getCodigoRetornoAdicional());
        assertTrue(true);
    }

    @Test
    public void getTransacao(){
        TransacaoDebitoServiceImpl ti=new TransacaoDebitoServiceImpl();
        TransacaoDebito t=null;
        try {
            t = ti.getTransacao(new Long(2354), "1", 2l, 1l);
        } catch (TransacaoNotFoundException ex) {
            fail("not found...");
        }
        assertNotNull(t);
    }
}
