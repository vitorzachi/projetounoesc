package br.unoesc.ws.webServiceMethods;

import br.unoesc.ws.configs.CodigosRetorno;
import br.unoesc.ws.exceptions.AlterarException;
import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.Produtor;
import br.unoesc.ws.model.Transacao;
import br.unoesc.ws.serviceModel.TransacaoServiceImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author vitor
 */
@WebService(serviceName = "TransacaoWS")
public class TransacaoWebService {

    @WebMethod(operationName = "incluirTransacao")
    public Integer incluiTransacaoWeb(@WebParam(name = "Transacao") Transacao t) throws SalvarException{
        TransacaoServiceImpl tImpl = new TransacaoServiceImpl();
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
