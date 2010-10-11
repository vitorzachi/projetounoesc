
import br.unoesc.ws.test.cereal.CerealTeste;
import br.unoesc.ws.test.empresa.EmpresaTeste;
import br.unoesc.ws.test.entitymanager.EntityManagerTest;
import br.unoesc.ws.test.estado.EstadoTeste;
import br.unoesc.ws.test.multiplicador.MultiplicadorTeste;
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
//        et.getQueryTest();

//        -----------------------------
        EstadoTeste e=new EstadoTeste();
        e.insereEstadoTeste();
        e.insereEstadoTeste2();


        CerealTeste ct = new CerealTeste();
        ct.insereCereal();
        ct.insereCerea2l();
        ct.getCerealPorNomeTeste();


        SafraTest st = new SafraTest();
        st.insereSafraTeste();
        st.insereSafraTeste2();
        st.getSafraTest();

        ProdutorTest pt = new ProdutorTest();
        pt.insereProdutor();

        EmpresaTeste emt = new EmpresaTeste();
        emt.insereEmpresa();
        emt.insereEmpresa2();

        PrecoSafraTest pst = new PrecoSafraTest();
        pst.inserePreco();
//        pst.inserePreco2();

        MultiplicadorTeste mt=new MultiplicadorTeste();
        mt.insereMultiplicador();
        mt.insereMultiplicador2();
        
        TransacaoTest tt = new TransacaoTest();
        tt.insereTransacaoCredito();
        tt.insereTransacaoCredito2();


    }
}
