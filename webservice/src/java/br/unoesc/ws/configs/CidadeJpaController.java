/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unoesc.ws.configs;

import br.unoesc.ws.configs.exceptions.NonexistentEntityException;
import br.unoesc.ws.model.Cidade;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;

/**
 *
 * @author leandro
 */
public class CidadeJpaController {

    public CidadeJpaController() {
        emf = Persistence.createEntityManagerFactory("webserviceUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Cidade cidade) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(cidade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Cidade cidade) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            cidade = em.merge(cidade);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = cidade.getId();
                if (findCidade(id) == null) {
                    throw new NonexistentEntityException("The cidade with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Long id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Cidade cidade;
            try {
                cidade = em.getReference(Cidade.class, id);
                cidade.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The cidade with id " + id + " no longer exists.", enfe);
            }
            em.remove(cidade);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Cidade> findCidadeEntities() {
        return findCidadeEntities(true, -1, -1);
    }

    public List<Cidade> findCidadeEntities(int maxResults, int firstResult) {
        return findCidadeEntities(false, maxResults, firstResult);
    }

    private List<Cidade> findCidadeEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Cidade as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Cidade findCidade(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Cidade.class, id);
        } finally {
            em.close();
        }
    }

    public int getCidadeCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Cidade as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
