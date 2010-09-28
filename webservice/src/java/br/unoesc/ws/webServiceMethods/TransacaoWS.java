/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unoesc.ws.webServiceMethods;

import br.unoesc.ws.configs.CodigosRetorno;
import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.TransacaoCredito;
import br.unoesc.ws.serviceModel.CerealServiceImpl;
import br.unoesc.ws.serviceModel.EmpresaServiceImpl;
import br.unoesc.ws.serviceModel.ProdutorServiceImpl;
import br.unoesc.ws.serviceModel.TransacaoCreditoServiceImpl;
import br.unoesc.ws.webmodel.TransacaoCreditoModel;
import java.util.Date;
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
    public Integer incluirCredito(@WebParam(name="transacaoCredito")TransacaoCreditoModel t) {

        TransacaoCreditoServiceImpl ti = new TransacaoCreditoServiceImpl();
        CerealServiceImpl c = new CerealServiceImpl();
        EmpresaServiceImpl e = new EmpresaServiceImpl();
        ProdutorServiceImpl p = new ProdutorServiceImpl();

        TransacaoCredito tc = new TransacaoCredito();

        try {
            tc.setDataTransacao(new Date());

            tc.setCereal(c.getCerealById(t.getCodCereal()));

            tc.setEmpresaGeradora(e.getById(t.getCodEmpresa()));

            tc.setNumeroNotaFiscal(t.getNumNotaFiscal());

            tc.setProdutor(p.getByCPF(t.getCpfProdutor()));

            tc.setQuantidade(t.getQtdComprada());

            tc.setSerieNotaFiscal(null);
        } catch (Exception ex) {
        }


        try {
            ti.salvar(tc);
            return CodigosRetorno.SUCESSO_AO_SALVAR;
        } catch (SalvarException ex) {
            return CodigosRetorno.ERRO_AO_SALVAR;
        }
    }
}
