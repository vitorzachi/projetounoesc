package br.unoesc.ws.serviceModel;

import br.unoesc.ws.exceptions.CerealNotFoundException;
import br.unoesc.ws.model.Cereal;
import br.unoesc.ws.model.Safra;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author leandro
 */
public class CerealServiceImpl extends GenericServiceImpl<Cereal> {

    public Cereal getCerealById(Long codigo) throws CerealNotFoundException {
        Cereal c = super.getById(codigo);
        if (c == null) {
            throw new CerealNotFoundException();
        } else {
            return c;
        }
    }

    public Cereal getCerealPorNome(String nome) throws CerealNotFoundException {
        EntityManager em = null;
        Cereal cereal;
        try {
            em = getEntityManager();
            Query query = em.createQuery("select c from Cereal c where c.nome like :nome");
            query.setParameter("nome", nome);
            cereal = (Cereal) query.getSingleResult();
            if (cereal == null) {
                throw new CerealNotFoundException("Nenhum cereal cadastrado com esse nome");
            } else {
                return cereal;
            }
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
}
