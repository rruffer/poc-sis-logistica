package util;

import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @author Rodolfo.ruffer
 *
 */
public class UtilJSF {
	
	/**
	 * m�todo que redireciona usu�rio para outra p�gina
	 * @param pagina
	 */
	public static void redirecionar(String pagina){
		try {
			FacesContext.getCurrentInstance().getExternalContext().redirect(pagina);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * M�todo que informa a pasta ra�z do sistema
	 * @return
	 */
	public static ServletContext pastaRaiz(){
		ServletContext context = (ServletContext) FacesContext.getCurrentInstance().getExternalContext().getContext();
		
		return context;
	}
	
	public static HttpServletRequest getRequest() {
		FacesContext fc = FacesContext.getCurrentInstance();
	       HttpServletRequest request = (HttpServletRequest) fc.getExternalContext().getRequest();
		
        return request;
    }

	/**
	 * M�todo que retorna mensagens na interface da aplica��o para o usu�rio
	 * @param mensagem
	 */
	public static void msgInformacao(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

	/**
	 * M�todo que retorna mensagens de <i><b>alerta</b></i> na interface da aplica��o para o usu�rio
	 * @param mensagem
	 */
	public static void msgAlerta(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_WARN, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	/**
	 * M�todo que retorna mensagens de <i><b>erro</b></i> na interface da aplica��o para o usu�rio
	 * @param mensagem
	 */
	public static void msgErro(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_ERROR, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	/**
	 * M�todo que retorna mensagens de <i><b>erro fatal</b></i> na interface da aplica��o para o usu�rio
	 * @param mensagem
	 */
	public static void msgFatal(String mensagem) {
		FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_FATAL, mensagem, null);
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}

}
