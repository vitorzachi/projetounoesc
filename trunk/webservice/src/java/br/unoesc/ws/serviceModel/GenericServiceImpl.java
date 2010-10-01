
package br.unoesc.ws.serviceModel;

import br.unoesc.ws.exceptions.AlterarException;
import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.GenericModel;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.*;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author vitor
 */
public class GenericServiceImpl<ModelClass extends GenericModel> {

    private static EntityManagerFactory emf = null;
    private Class<ModelClass> modelClazz;

    /**
     * método construtor que descobre qual é a classe que esta sendo utilizada
     * no ModelClass
     */
    public GenericServiceImpl() {
        Type[] types = ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments();
//        setando o ModelClass.class
        this.modelClazz = (Class<ModelClass>) types[types.length > 1 ? 1 : 0];
    }

    private static void createFactory() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("webserviceUnit");
        }
    }

    protected EntityManager getEntityManager() {
        createFactory();
        return emf.createEntityManager();
    }

    public void salvar(ModelClass objeto) throws SalvarException {
        EntityManager em = null;
        try {
            em = getEntityManager(); //Pego entityManager que possui a conexao com o banco
            em.getTransaction().begin(); //inicio uma transação com o banco
            em.persist(objeto);//faço o insert
            em.getTransaction().commit();//fecho a transação com um commit
        } catch (Exception e) {
            throw new SalvarException(e.getMessage());
        } finally {
            if (em != null) {
                em.close();//encerro a conexao;
            }
        }
    }

    public void alterar(ModelClass objeto) throws AlterarException {
        EntityManager em = null;
        try {
            em = getEntityManager(); //Pego entityManager que possui a conexao com o banco
            em.getTransaction().begin(); //inicio uma transação com o banco
            objeto = em.merge(objeto);//faço alteracao nos dados do objeto
            em.getTransaction().commit();//fecho a transação com um commit
        }catch(Exception e){
            throw new AlterarException(e.getMessage());
        } finally {
            if (em != null) {
                em.close();//encerro a conexao;
            }
        }
    }

    public void excluir(Long codigo) {
        EntityManager em = null;
        try {
            em = getEntityManager(); //Pego entityManager que possui a conexao com o banco
            em.getTransaction().begin(); //inicio uma transação com o banco
            ModelClass objeto = em.getReference(this.modelClazz, codigo);
            em.remove(objeto);//exclusao do objeto
            em.getTransaction().commit();//fecho a transação com um commit
        } finally {
            if (em != null) {
                em.close();//encerro a conexao;
            }
        }
    }

    protected  ModelClass getById(Long codigo) {
        EntityManager em = null;
        try {
            em = getEntityManager();
            return em.find(this.modelClazz, codigo);
            
        } finally {
            em.close();
        }
    }

    public List<ModelClass> getAll() {
        EntityManager em = null;
        try {
            em = getEntityManager();
            Query query = em.createQuery("select p from " + this.modelClazz.getName() + " p");
            return query.getResultList();
        } finally {
            em.close();
        }
    }

    public void salvarOuAlterar(ModelClass modelClass) throws SalvarException, AlterarException{
        if(modelClass.getId()!=null){
            alterar(modelClass);
        }else{
            salvar(modelClass);
        }
    }
}

