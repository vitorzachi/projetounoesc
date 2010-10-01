
package br.unoesc.ws.serviceModel;

import br.unoesc.ws.exceptions.EmpresaNaoAutorizadaException;
import br.unoesc.ws.model.Empresa;
import javax.persistence.EntityManager;

/**
 *
 * @author leandro
 */
public class EmpresaServiceImpl extends GenericServiceImpl<Empresa>{


    public Empresa getEmpresaById(Long codigo) throws EmpresaNaoAutorizadaException{
        EntityManager em = null;
        Empresa e=null;
        try {
            em = getEntityManager();
            e=em.find(Empresa.class, codigo);
            if(e!=null){
                return e;
            }else{
                throw new EmpresaNaoAutorizadaException();
            }
        } finally {
            em.close();
        }
    }
}
