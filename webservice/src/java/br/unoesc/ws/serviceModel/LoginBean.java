package br.unoesc.ws.serviceModel;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author leandro
 */
public class LoginBean {

    private String login;
    private String senha;
    private UsuarioServiceImpl user;

    public LoginBean() {
        user = new UsuarioServiceImpl();
    }

    /**
     * Método responsável por executar a ação de Login
     * @return String contendo o forward
     */
    public String acao() {
        boolean sucesso = true;
        FacesContext context = FacesContext.getCurrentInstance();

        if (user.getUsuarioPorNome(login) != null) {
            for (int i = 0; i < getLogin().length(); i++) {
                char c = getLogin().charAt(i);
                //Senão for letra ou espaço
                if (!Character.isLetter(c) && !Character.isSpaceChar(c)) {
                    String msg = "Digite somente caracteres alfabéticos.";
                    FacesMessage message = new FacesMessage(msg);
                    context.addMessage("formulario", message);
                    sucesso = false;
                    break;
                }
            }
        } else {
            String msg = "Usuário não existe!";
            FacesMessage message = new FacesMessage(msg);
            context.addMessage("formulario", message);
            sucesso = false;
        }


        if (!getSenha().equals("123") || getSenha() == null) {
            String msg = "Senha está incorreta!";
            FacesMessage message = new FacesMessage(msg);
            context.addMessage("formulario", message);
            sucesso = false;
        }
        return (sucesso ? "sucesso" : "falha");
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
