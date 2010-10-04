/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package br.unoesc.ws.serviceModel;

import br.unoesc.ws.model.PrecoSafra;
import br.unoesc.ws.model.Safra;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author vitor
 */
public class PrecoSafraServiceImpl extends GenericServiceImpl<PrecoSafra> {

    public PrecoSafra getPrecoPorSafra(Safra safra){
         EntityManager em = null;
        try {
            em = getEntityManager();
            Query query = em.createQuery("select p from PrecoSafra p where :safra = p.safra");
            query.setParameter("safra",safra);
            return (PrecoSafra)query.getSingleResult();
        } finally {
            em.close();
        }
    }
}
