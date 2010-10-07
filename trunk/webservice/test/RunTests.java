
import br.unoesc.ws.test.cereal.CerealTeste;
import br.unoesc.ws.test.empresa.EmpresaTeste;
import br.unoesc.ws.test.entitymanager.EntityManagerTest;
import br.unoesc.ws.test.precoSafra.PrecoSafraTest;
import br.unoesc.ws.test.produtor.ProdutorTest;
import br.unoesc.ws.test.safra.SafraTest;
import br.unoesc.ws.test.transacao.TransacaoTest;

/**
 *
 * @author vitor
 */
public class RunTests {

    public static void main(String[] args) {
//    [-------- inicio da bateria de testes em ordem de necessidade de execucao --------]
        EntityManagerTest et = new EntityManagerTest();
        et.getEntityManagerTest();
        et.getQueryTest();

//        -----------------------------
        CerealTeste ct = new CerealTeste();
        ct.insereCereal();
        ct.getCerealPorNomeTeste();


        SafraTest st = new SafraTest();
        st.insereSafraTeste();
        st.getSafraTest();

        ProdutorTest pt = new ProdutorTest();
        pt.insereProdutor();

        EmpresaTeste emt = new EmpresaTeste();
        emt.insereEmpresa();

        PrecoSafraTest pst = new PrecoSafraTest();
        pst.inserePreco();

        TransacaoTest tt = new TransacaoTest();
        tt.insereTransacaoCredito();


    }
}
