

package br.unoesc.ws.serviceModel;

import br.unoesc.ws.model.Cereal;
import br.unoesc.ws.model.Estado;
import br.unoesc.ws.model.MultiplicadorEstadoSafra;
import br.unoesc.ws.model.Safra;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author vitor
 */
public class MultiplicadorEstadoSafraServiceImpl extends GenericServiceImpl<MultiplicadorEstadoSafra>{

    public MultiplicadorEstadoSafra getMultiplicadorSafraCorrentePorEstado(Cereal c,Estado e){
        EntityManager em=null;
        Safra s=new SafraServiceImpl().getSafraCorrente(c);
        try {
            em=getEntityManager();
            Query q=em.createQuery("select m from MultiplicadorEstadoSafra m where((m.safra=:s)and(m.estadoPlantio=:e))");
            q.setParameter("s", s);
            q.setParameter("e", e);
            return (MultiplicadorEstadoSafra) q.getSingleResult();
        } finally {
            em.close();
        }
    }
}
