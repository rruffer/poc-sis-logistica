package security;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import model.User;

/**
 * @link https://arjan-tijms.omnifaces.org/p/jsf-23.html
 * @author rruffer
 *
 */
@Named("logonMB")
@SessionScoped
public class LogonMB implements Serializable{
	
	private static final long serialVersionUID = 5993653751816846078L;

	@Inject
	FacesContext facesContext;
	
/*	@Stateful
	 @PersistenceContext(unitName = "logistica", type = PersistenceContextType.EXTENDED)
	    private EntityManager entityManager;*/
	
	private User user;
	
	private Integer matricula;
	private String senha;

	public String logon() {
		
		user = new User(matricula, senha);
		
/*		UserDAO userDao = new UserDAO();
		
		userDao.salvar(user);*/
		
		if(user.getMatricula().equals(111) && user.getSenha().equals("111")) {
			
			try {
				facesContext.getCurrentInstance().getExternalContext().redirect("/sis-logistica-0.0.2/restricted/index.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Usuário não existe", null);
			facesContext.getCurrentInstance().addMessage(null, message);
			user = null;
		}
		
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
