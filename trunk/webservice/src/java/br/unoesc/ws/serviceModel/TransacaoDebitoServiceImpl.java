
package br.unoesc.ws.serviceModel;

import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.TransacaoDebito;

/**
 *
 * @author vitor
 */
public class TransacaoDebitoServiceImpl extends GenericServiceImpl<TransacaoDebito>{


    @Override
    public void salvar(TransacaoDebito t)throws SalvarException{
        ProdutorServiceImpl produtorService=new ProdutorServiceImpl();

    }
}
