/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.unoesc.ws.test.entitymanager;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vitor
 */
public class EntityManagerTest {

    @Test
    public void getEntityManagerTest() {
        EntityManagerFactory emf = null;
        emf = Persistence.createEntityManagerFactory("webserviceUnit");
        EntityManager em = emf.createEntityManager();
        assertNotNull(em);
    }

//    @Test
//    public void getQueryTest() {
//        EntityManagerFactory emf = null;
//        emf = Persistence.createEntityManagerFactory("webserviceUnit");
//        EntityManager em = emf.createEntityManager();
//
//        Date i=new Date();
//        Date j=new Date();
//        Query q = em.createQuery("select Sum(t.quantidade) " +
//                "from TransacaoCredito t where ((t.produtor=:p) and " +
//                "(t.cereal=:c)) and (t.dataTransacao between :i and :j))");
//
//        assertNotNull(q);
//    }

}
