/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unoesc.ws.webServiceMethods;

import br.unoesc.ws.configs.CodigosRetorno;
import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.TransacaoCredito;
import br.unoesc.ws.serviceModel.TransacaoCreditoServiceImpl;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author vitor
 */
@WebService
public class TransacaoWS {

    @WebMethod
    public Integer incluirCredito(@WebParam(name="transacao")TransacaoCredito t){
        TransacaoCreditoServiceImpl ti=new TransacaoCreditoServiceImpl();
        try {
            ti.salvar(t);
            return CodigosRetorno.SUCESSO_AO_SALVAR;
        } catch (SalvarException ex) {
            return CodigosRetorno.ERRO_AO_SALVAR;
        }
    }
}
