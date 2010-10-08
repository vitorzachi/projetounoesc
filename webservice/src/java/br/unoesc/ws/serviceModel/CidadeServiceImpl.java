
package br.unoesc.ws.serviceModel;

import br.unoesc.ws.exceptions.CidadeNotFoundException;
import br.unoesc.ws.model.Cidade;

/**
 *
 * @author leandro
 */
public class CidadeServiceImpl extends GenericServiceImpl<Cidade> {

    
    public Cidade getCidadeById(Long id) throws CidadeNotFoundException{
        Cidade c=super.getById(id);
        if(c==null){
            throw new CidadeNotFoundException();
        }else{
            return c;
        }
    }
}
