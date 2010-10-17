
package br.unoesc.ws.serviceModel;

import br.unoesc.ws.model.Usuario;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author leandro
 */
public class UsuarioServiceImpl extends GenericServiceImpl<Usuario>{

     @Override
    public Usuario getById(Long codigo){
        return super.getById(codigo);
    }

public Usuario getUsuarioPorNome(String nome) {
         EntityManager em = null;

        try {
            em = getEntityManager();
            Query query = em.createQuery("select c from Usuario c where c.usuario like :nome");
            query.setParameter("nome",nome);
            return (Usuario)query.getSingleResult();
        } finally {
            em.close();
        }
    }
}
