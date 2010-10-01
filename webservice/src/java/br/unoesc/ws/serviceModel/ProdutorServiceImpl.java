

package br.unoesc.ws.serviceModel;

import br.unoesc.ws.exceptions.ProdutorNotFoundException;
import br.unoesc.ws.model.Produtor;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**classe responsável por prover servicos de persistencia e CRUD da classe
 * @see Produtor
 *
 * @author vitor
 */
public class ProdutorServiceImpl extends GenericServiceImpl<Produtor>{

    /**
     *
     * @param cpf
     * @return
     * @throws ProdutorNotFoundException
     */
    public Produtor getByCPF(String cpf) throws ProdutorNotFoundException {
        EntityManager em = null;
        Produtor p=null;
        try {
            em = getEntityManager();
            Query query = em.createQuery("select p from Produtor p where p.cpf like :cpf");
            query.setParameter("cpf", cpf);
            p=(Produtor)query.getSingleResult();

            if(p==null){
                throw new ProdutorNotFoundException();
            }else{
                return p;
            }
        } finally {
            em.close();
        }
    }
}
