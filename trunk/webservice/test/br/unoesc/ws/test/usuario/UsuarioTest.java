
package br.unoesc.ws.test.usuario;

import br.unoesc.ws.exceptions.SalvarException;
import br.unoesc.ws.model.Usuario;
import br.unoesc.ws.serviceModel.UsuarioServiceImpl;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;

/**
 *
 * @author leandro
 */
public class UsuarioTest {


     @Test
    public void insereUsuario(){
        Usuario e=new Usuario();
        UsuarioServiceImpl ei=new UsuarioServiceImpl();

       // e.setId(4l);
        e.setUsuario("admin");
        e.setSenha("pass");

        try {
            ei.salvar(e);
        } catch (SalvarException ex) {
            Logger.getLogger(UsuarioTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
