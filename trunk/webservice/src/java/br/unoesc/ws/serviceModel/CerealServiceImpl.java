
package br.unoesc.ws.serviceModel;

import br.unoesc.ws.exceptions.CerealNotFoundException;
import br.unoesc.ws.model.Cereal;

/**
 *
 * @author leandro
 */
public class CerealServiceImpl extends GenericServiceImpl<Cereal>{

    public Cereal getCerealById(Long codigo) throws CerealNotFoundException {
        Cereal c=super.getById(codigo);
        if(c==null){
            throw new CerealNotFoundException();
        }else{
            return c;
        }
    }


}
