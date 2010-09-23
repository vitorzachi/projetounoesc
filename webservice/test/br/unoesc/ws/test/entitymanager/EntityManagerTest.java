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
    public void getEntityManagerTest(){
        EntityManagerFactory emf=null;
        emf=Persistence.createEntityManagerFactory("webserviceUnit");
        EntityManager em=emf.createEntityManager();
        assertNotNull(em);
    }
}
