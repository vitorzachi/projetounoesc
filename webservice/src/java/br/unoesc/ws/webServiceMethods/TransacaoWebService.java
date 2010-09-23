
package br.unoesc.ws.webServiceMethods;

import br.unoesc.ws.model.Produtor;
import br.unoesc.ws.model.Transacao;
import br.unoesc.ws.serviceModel.TransacaoServiceImpl;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author vitor
 */
@WebService(serviceName="TransacaoWS")
public class TransacaoWebService {

    @WebMethod(operationName="incluirTransacao")
    public Integer incluiTransacaoWeb(@WebParam(name="Produtor")Produtor p,@WebParam(name="Transacao")Transacao t){
        TransacaoServiceImpl tImpl=new TransacaoServiceImpl();
        return tImpl.incluiTransacao(p, t);
    }
}
