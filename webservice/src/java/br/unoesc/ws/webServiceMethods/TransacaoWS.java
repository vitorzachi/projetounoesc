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
    public Integer incluirCredito(@WebParam(name = "codCereal") Long codCereal,
            @WebParam(name = "codEmpresa") Long codEmpresa,
            @WebParam(name = "cpfProdutor") String cpfProdutor,
            @WebParam(name = "numNotaFiscal") Long numNotaFiscal,
            @WebParam(name = "qtdComprada") Float qtdComprada) {

        TransacaoCreditoServiceImpl ti = new TransacaoCreditoServiceImpl();
        CerealServiceImpl c = new CerealServiceImpl();
        EmpresaServiceImpl e = new EmpresaServiceImpl();
        ProdutorServiceImpl p = new ProdutorServiceImpl();

        TransacaoCredito tc = new TransacaoCredito();

        try {
            tc.setDataTransacao(new Date());

            tc.setCereal(c.getCerealById(codCereal));

            tc.setEmpresaGeradora(e.getById(codEmpresa));

            tc.setNumeroNotaFiscal(numNotaFiscal);

            tc.setProdutor(p.getByCPF(cpfProdutor));

            tc.setQuantidade(qtdComprada);

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
