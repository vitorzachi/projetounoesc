
package br.unoesc.ws.serviceModel;

import br.unoesc.ws.exceptions.AlterarException;
import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.TransacaoCredito;

/**
 *
 * @author vitor
 */
public class TransacaoCreditoServiceImpl extends GenericServiceImpl<TransacaoCredito>{

    public void incluiTransacao(TransacaoCredito t)
            throws SalvarException,
            AlterarException{

        salvarOuAlterar(t);
    }
}
