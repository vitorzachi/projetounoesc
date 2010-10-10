package br.unoesc.ws.serviceModel;

import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.exceptions.TransacaoNotFoundException;
import br.unoesc.ws.model.Boleto;
import br.unoesc.ws.model.PrecoSafra;
import br.unoesc.ws.model.TransacaoCredito;
import java.util.Date;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author vitor
 */
public class TransacaoCreditoServiceImpl extends GenericServiceImpl<TransacaoCredito> {

    @Override
    public void salvar(TransacaoCredito t)
            throws SalvarException {

        Boleto b = new Boleto();
        b.setTransacaoCredito(t);
        b.setPago(false);
        b.setValor(this.getValorBoleto(t));
        t.setBoletoGerado(b);

        super.salvar(t);
    }

    private Float getValorBoleto(TransacaoCredito t) {
        PrecoSafraServiceImpl psImpl = new PrecoSafraServiceImpl();
        PrecoSafra ps = psImpl.getPrecoPorSafra(t.getSafra());
        return ps.getPrecoPorKgSemente() * t.getQuantidade();
    }

    public TransacaoCredito getTransacao(Long numNotaFiscal,
            String serieNotaFiscal, Long codEmpresa, Long codCereal)
            throws TransacaoNotFoundException {
        EntityManager em = null;
        TransacaoCredito t = null;
        Date d = new Date();
        try {
            em = getEntityManager();
            Query q = em.createQuery("select t from TransacaoCredito t where" +
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

            t = (TransacaoCredito) q.getSingleResult();
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
