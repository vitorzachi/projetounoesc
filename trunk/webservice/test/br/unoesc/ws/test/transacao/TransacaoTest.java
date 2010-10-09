/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unoesc.ws.test.transacao;

import br.unoesc.ws.exceptions.CerealNotFoundException;
import br.unoesc.ws.serviceModel.CerealServiceImpl;
import br.unoesc.ws.serviceModel.EmpresaServiceImpl;
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

        IncluirTransacaoSampleModel tm = new IncluirTransacaoSampleModel(1l, 2l, "05456216900", "1", new Long(2345), 250, 1l, "pass");
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

        IncluirTransacaoSampleModel tm = new IncluirTransacaoSampleModel(1l, 2l, "05456216900", "1", new Long(2353), 100, 1l, "pass");
        TransacaoWS tws = new TransacaoWS();
        ObjetoRetorno o = tws.incluirDebito(tm);
        System.out.println(o.getCodigoRetorno());
        System.out.println(o.getMensagemRetorno());

        System.out.println(o.getDescricaoCodRetornoAdicional());
        System.out.println(o.getCodigoRetornoAdicional());
        assertTrue(true);
    }
}
