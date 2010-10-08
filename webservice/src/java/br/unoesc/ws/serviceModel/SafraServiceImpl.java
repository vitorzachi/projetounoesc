package br.unoesc.ws.serviceModel;

import br.unoesc.ws.exceptions.SafraJaExisteException;
import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.Cereal;
import br.unoesc.ws.model.Estado;
import br.unoesc.ws.model.Safra;
import java.util.Date;
import javax.persistence.*;
import javax.persistence.EntityManager;

/**
 *
 * @author leandro
 */
public class SafraServiceImpl extends GenericServiceImpl<Safra> {

    public Safra getSafraCorrente(Cereal c,Estado estadoPlantio) {
        return this.getSafraPelaData(c, new Date(),estadoPlantio);
    }

    public Safra getSafraPelaData(Cereal c, Date d,Estado estadoPlantio) {
        EntityManager em = null;
        Safra safra = null;

        try {
            em = getEntityManager();
            Query query = em.createQuery("select s from Safra s where" +
                    " ((:d between s.inicioSafra and s.fimSafra)" +
                    " and (s.cereal=:c) and (s.estadoPlantio=:e))");
            query.setParameter("d", d);
            query.setParameter("c", c);
            query.setParameter("e", estadoPlantio);

            try {
                safra = (Safra) query.getSingleResult();
            } catch (Exception e) {
            }
            return safra;
        } finally {
            em.close();
        }
    }

    @Override
    public void salvar(Safra safra) throws SalvarException {
        Safra s = this.getSafraCorrente(safra.getCereal(),safra.getEstadoPlantio());
        if (s != null) {
            throw new SafraJaExisteException();
        }
        super.salvar(safra);
    }
}
