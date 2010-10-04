/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unoesc.ws.test.transacao;

import br.unoesc.ws.webModelEntrada.TransacaoSampleModel;
import br.unoesc.ws.webModelRetorno.ObjetoRetorno;
import br.unoesc.ws.webServiceMethods.TransacaoWS;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitor
 */
public class TransacaoTest {

    @Test
    public void insereTransacaoCredito() {
        TransacaoSampleModel tm = new TransacaoSampleModel(new Long(2), new Long(2), "11122233344", "1", new Long(2345), 250, "senha");
        TransacaoWS tws = new TransacaoWS();
        ObjetoRetorno o = tws.incluirCredito(tm);
        System.out.println(o.getCodigoRetorno());
        System.out.println(o.getMensagemRetorno());

        System.out.println(o.getDescricaoCodRetornoAdicional());
        System.out.println(o.getCodigoRetornoAdicional());
        assertTrue(true);
    }
}
