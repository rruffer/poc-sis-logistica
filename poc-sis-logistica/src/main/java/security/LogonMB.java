package security;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.persistence.TypedQuery;

import dao.UserDAO;
import model.User;
import util.UtilJSF;

/**
 * @link https://arjan-tijms.omnifaces.org/p/jsf-23.html
 * @author rruffer
 *
 */
@Named("logonMB")
@SessionScoped
public class LogonMB implements Serializable {

	private static final long serialVersionUID = 5993653751816846078L;

	@Inject
	FacesContext facesContext;

	@Inject
	private UserDAO userDAO;

	private User user;

	private Integer matricula;
	private String senha;

	public String logon() {

		user = userDAO.buscarUsuario(matricula, senha);

		if (user != null) {

			UtilJSF.redirecionar("/logistica/pages/private/index.xhtml");
			UtilJSF.msgInformacao("Usuário logado com sucesso!");

		} else {

			UtilJSF.msgAlerta("Usuário não existe");
		}

		return null;
	}

	public String login() {

		user = null;
		UtilJSF.redirecionar("/logistica/pages/public/login.xhtml");

		return null;
	}

	public Integer getMatricula() {
		return matricula;
	}

	public void setMatricula(Integer matricula) {
		this.matricula = matricula;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
