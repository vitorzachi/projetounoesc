/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unoesc.ws.configs;

import br.unoesc.ws.configs.exceptions.NonexistentEntityException;
import br.unoesc.ws.model.Produtor;
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
public class ProdutorJpaController {

    public ProdutorJpaController() {
        emf = Persistence.createEntityManagerFactory("webserviceUnit");
    }
    private EntityManagerFactory emf = null;

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void create(Produtor produtor) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(produtor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Produtor produtor) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            produtor = em.merge(produtor);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Long id = produtor.getId();
                if (findProdutor(id) == null) {
                    throw new NonexistentEntityException("The produtor with id " + id + " no longer exists.");
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
            Produtor produtor;
            try {
                produtor = em.getReference(Produtor.class, id);
                produtor.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The produtor with id " + id + " no longer exists.", enfe);
            }
            em.remove(produtor);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public List<Produtor> findProdutorEntities() {
        return findProdutorEntities(true, -1, -1);
    }

    public List<Produtor> findProdutorEntities(int maxResults, int firstResult) {
        return findProdutorEntities(false, maxResults, firstResult);
    }

    private List<Produtor> findProdutorEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Produtor as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Produtor findProdutor(Long id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Produtor.class, id);
        } finally {
            em.close();
        }
    }

    public int getProdutorCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Produtor as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
