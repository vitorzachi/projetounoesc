
package br.unoesc.ws.serviceModel;

import br.unoesc.ws.model.Safra;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.EntityManager;

/**
 *
 * @author leandro
 */
public class SafraServiceImpl extends GenericServiceImpl<Safra> {

    public Safra getSafraCorrente(){
         EntityManager em = null;
        try {
            em = getEntityManager();
            Date d=new Date();
            Query query = em.createQuery("select s from Safra s where :d between s.dataInicioSafra and s.dataFimSafra");
            query.setParameter("d",d);
            return (Safra)query.getSingleResult();
        } finally {
            em.close();
        }
    }

}
