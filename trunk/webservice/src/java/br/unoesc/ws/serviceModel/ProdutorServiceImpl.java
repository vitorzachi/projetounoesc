package br.unoesc.ws.serviceModel;

import br.unoesc.ws.exceptions.ProdutorNotFoundException;
import br.unoesc.ws.model.Cereal;
import br.unoesc.ws.model.Produtor;
import br.unoesc.ws.model.Safra;
import br.unoesc.ws.model.TransacaoCredito;
import java.util.Date;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

/**classe responsável por prover servicos de persistencia e CRUD da classe
 * @see Produtor
 *
 * @author vitor
 */
public class ProdutorServiceImpl extends GenericServiceImpl<Produtor> {

    /**
     *
     * @param cpf
     * @return
     * @throws ProdutorNotFoundException
     */
    public Produtor getByCPF(String cpf) throws ProdutorNotFoundException {
        EntityManager em = null;
        Produtor p = null;
        try {
            em = getEntityManager();
            Query query = em.createQuery("select p from Produtor p where p.cpf like :cpf");
            query.setParameter("cpf", cpf);
            p = (Produtor) query.getSingleResult();

            if (p == null) {
                throw new ProdutorNotFoundException();
            } else {
                return p;
            }
        } finally {
            em.close();
        }
    }

    public Long getSaldoRoyalties(Produtor p, Safra s) {
        return getCreditosRoyalties(p, s) - getDebitosRoyalties(p, s);
    }

    public Long getCreditosRoyalties(Produtor p, Safra s) {
        Long credito = new Long(0);
        List<TransacaoCredito> listaTransacoes;
       

        EntityManager em = null;
        try {
            em = getEntityManager();
            EntityTransaction ent = em.getTransaction();
            ent.begin();
            Query qCredito = em.createQuery("select t " +
                    "from TransacaoCredito t where ((t.produtor=:p) and " +
                    "(t.multiplicador.safra=:s) and (t.boletoGerado.pago=true))");

            qCredito.setParameter("p", p);
            qCredito.setParameter("s", s);
            listaTransacoes =  qCredito.getResultList();
        } finally {
            em.close();
        }

        if (credito == null) {
            credito = new Long(0);
        }

        for(TransacaoCredito tr:listaTransacoes){
            credito+=(tr.getQuantidade()*tr.getMultiplicador().getMultiplicador());
        }

        return credito;
    }

    public Long getDebitosRoyalties(Produtor p,Safra s){
        Long debitos=new Long(0);
       
        EntityManager em = null;
        try {
            em = getEntityManager();
            EntityTransaction ent = em.getTransaction();
            ent.begin();

            Query qDebito = em.createQuery("select Sum(t.quantidade) " +
                    "from TransacaoDebito t where ((t.produtor=:p) and " +
                    "(t.safra=:s))");

            qDebito.setParameter("p", p);
            qDebito.setParameter("s", s);
            debitos = (Long) qDebito.getSingleResult();
            ent.commit();
        } finally {
            em.close();
        }

        if (debitos == null) {
            debitos = new Long(0);
        }
        return debitos;
    }
}
