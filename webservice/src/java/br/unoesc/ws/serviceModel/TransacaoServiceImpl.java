
package br.unoesc.ws.serviceModel;

import br.unoesc.ws.exceptions.AlterarException;
import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.Transacao;

/**
 *
 * @author vitor
 */
public class TransacaoServiceImpl extends GenericServiceImpl<Transacao>{

    public void incluiTransacao(Transacao t) throws SalvarException, AlterarException{
        salvarOuAlterar(t);
    }
}
