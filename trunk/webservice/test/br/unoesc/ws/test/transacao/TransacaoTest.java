/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unoesc.ws.test.transacao;

import br.unoesc.ws.webModelEntrada.IncluirTransacaoSampleModel;
import br.unoesc.ws.webModelRetorno.ObjetoRetorno;
import br.unoesc.ws.webServiceMethods.TransacaoWS;
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

    @Test
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
}
