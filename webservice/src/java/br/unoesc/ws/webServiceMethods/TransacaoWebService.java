package br.unoesc.ws.webServiceMethods;

import br.unoesc.ws.configs.CodigosRetorno;
import br.unoesc.ws.exceptions.AlterarException;
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
@WebService()
public class TransacaoWebService {

    @WebMethod(operationName = "incluirTransacaoCredito")
    public Integer incluiTransacaoCreditoWeb(@WebParam(name = "TransacaoCred") TransacaoCredito t) throws SalvarException{
        TransacaoCreditoServiceImpl tImpl = new TransacaoCreditoServiceImpl();
        try {
            tImpl.incluiTransacao(t);
            return CodigosRetorno.SUCESSO_AO_SALVAR;
        } catch (SalvarException ex) {
            return CodigosRetorno.ERRO_AO_SALVAR;
        } catch (AlterarException ex) {
            return CodigosRetorno.ERRO_AO_SALVAR;
        }
    }
}
