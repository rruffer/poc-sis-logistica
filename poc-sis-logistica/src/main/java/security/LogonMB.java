package security;

import java.io.IOException;
import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * @link https://arjan-tijms.omnifaces.org/p/jsf-23.html
 * @author rruffer
 *
 */
@Named
@SessionScoped
public class LogonMB implements Serializable{
	
	private static final long serialVersionUID = 5993653751816846078L;

	@Inject
	FacesContext facesContext;

	private Integer matricula;
	private String senha;

	public String logon() {
		
		if(matricula.equals(111) && senha.equals("111")) {
			
			try {
				facesContext.getCurrentInstance().getExternalContext().redirect("/sis-logistica/faces/view/index.xhtml");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else {
			
			FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "teste login", null);
			facesContext.getCurrentInstance().addMessage(null, message);
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

}
