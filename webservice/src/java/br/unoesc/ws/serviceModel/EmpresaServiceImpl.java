
package br.unoesc.ws.serviceModel;

import br.unoesc.ws.exceptions.CerealNotFoundException;
import br.unoesc.ws.exceptions.EmpresaNaoAutorizadaException;
import br.unoesc.ws.model.Cereal;
import br.unoesc.ws.model.Empresa;
import javax.persistence.EntityManager;
import javax.persistence.Query;

/**
 *
 * @author leandro
 */
public class EmpresaServiceImpl extends GenericServiceImpl<Empresa>{


    public Empresa getEmpresaById(Long codigo) throws EmpresaNaoAutorizadaException{
        EntityManager em = null;
        Empresa e=null;
        try {
            em = getEntityManager();
            e=em.find(Empresa.class, codigo);
            if(e!=null){
                return e;
            }else{
                throw new EmpresaNaoAutorizadaException();
            }
        } finally {
            em.close();
        }
    }

    public Empresa getEmpresaPorNome(String nome) {
         EntityManager em = null;
//         Cereal cereal;
        try {
            em = getEntityManager();
            Query query = em.createQuery("select c from Empresa c where c.nomePessoa like :nome");
            query.setParameter("nome",nome);
            return (Empresa)query.getSingleResult();
//            if(cereal==null){
//                throw new CerealNotFoundException("Nenhum cereal cadastrado com esse nome");
//            }else{
//                return cereal;
//            }
        } finally {
            em.close();
        }
    }
}
