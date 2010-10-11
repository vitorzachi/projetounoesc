
package br.unoesc.ws.test.empresa;

import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.Empresa;
import br.unoesc.ws.serviceModel.EmpresaServiceImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author vitor
 */
public class EmpresaTeste {

    @Test
    public void insereEmpresa(){
        Empresa e=new Empresa();
        EmpresaServiceImpl ei=new EmpresaServiceImpl();

        e.setCnpj("83011247001889");
        e.setNomePessoa("tirol");
        e.setSenha("pass");

        try {
            ei.salvar(e);
        } catch (SalvarException ex) {
            Logger.getLogger(EmpresaTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Test
    public void insereEmpresa2(){
        Empresa e=new Empresa();
        EmpresaServiceImpl ei=new EmpresaServiceImpl();

        e.setCnpj("83305235000119");
        e.setNomePessoa("alfa");
        e.setSenha("pass");

        try {
            ei.salvar(e);
        } catch (SalvarException ex) {
            Logger.getLogger(EmpresaTeste.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
