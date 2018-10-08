package control;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import dao.SolicitacaoDAO;
import model.Solicitacao;

/**
 * @link https://arjan-tijms.omnifaces.org/p/jsf-23.html
 * @author rruffer
 *
 */
@Named("controleDeEventosMB")
@ViewScoped
public class ControleDeEventosMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	FacesContext facesContext;

	@Inject
	private SolicitacaoDAO solicitacaoDAO;
	
	private List<Solicitacao> listaSolicitacoes;

	
	@PostConstruct
	private void init() {
		
		listaSolicitacoes = solicitacaoDAO.findAll();
		
	}

	public List<Solicitacao> getListaSolicitacoes() {
		return listaSolicitacoes;
	}


	public void setListaSolicitacoes(List<Solicitacao> listaSolicitacoes) {
		this.listaSolicitacoes = listaSolicitacoes;
	}

	
}
