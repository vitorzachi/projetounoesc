
package br.unoesc.ws.serviceModel;

import br.unoesc.ws.exceptions.TransacaoNotFoundException;
import br.unoesc.ws.model.TransacaoCredito;
import br.unoesc.ws.model.TransacaoDebito;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author vitor
 */
public class TransacaoDebitoServiceImpl extends GenericServiceImpl<TransacaoDebito>{


//    @Override
//    public void salvar(TransacaoDebito t)throws SalvarException{
//
//
//    }
    public TransacaoDebito getTransacao(Long numNotaFiscal,
            String serieNotaFiscal, Long codEmpresa, Long codCereal)
            throws TransacaoNotFoundException {
        EntityManager em = null;
        TransacaoDebito t = null;
        Date d = new Date();
        try {
            em = getEntityManager();
            Query q = em.createQuery("select t from TransacaoDebito t where" +
                    " ((t.numeroNotaFiscal=:numNotaFiscal)and" +
                    "(t.serieNotaFiscal=:serieNotaFiscal)and" +
                    "(t.empresaGeradora=:codEmpresa)and" +
                    "(t.safra.cereal=:codCereal)and" +
                    "(:d between t.safra.inicioSafra and t.safra.fimSafra))");

            q.setParameter("numNotaFiscal", numNotaFiscal);
            q.setParameter("serieNotaFiscal", serieNotaFiscal);
            q.setParameter("codEmpresa", codEmpresa);
            q.setParameter("codCereal", codCereal);
            q.setParameter("d", d);

            t = (TransacaoDebito) q.getSingleResult();
            if (t == null) {
                throw new TransacaoNotFoundException();
            }
            return t;

        } finally {
            if (em != null) {
                em.close();
            }
        }

    }
}
