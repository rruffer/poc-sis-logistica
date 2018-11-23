package control;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.PrimeFaces;

import dao.MotoristaDAO;
import dao.SolicitacaoDAO;
import model.Motorista;
import model.Solicitacao;
import util.UtilJSF;

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

	@Inject
	private MotoristaDAO motoristaDAO;
	
	private List<Solicitacao> listaSolicitacoes;
	private List<SelectItem> selectMotorista;
	private Solicitacao solicitacao;
	private Long idMotorista;

	
	@PostConstruct
	private void init() {
		solicitacao = new Solicitacao();
		
		listaSolicitacoes = solicitacaoDAO.findAll();
		
		List<Motorista>	listaMotoristas = motoristaDAO.findAll();
		
		selectMotorista = new ArrayList<>();
		
		for(Motorista m : listaMotoristas) {
			selectMotorista.add(new SelectItem(m.getId(), m.getNome()));
		}
		
	}

	/**
	 * Popula oobjeto solicitação
	 * @param solicitacao
	 */
	public void definirCarga(Solicitacao solicitacao) {
		
		this.solicitacao = solicitacao;
		
		if(this.solicitacao.getMotorista() != null) {
			idMotorista = solicitacao.getMotorista().getId();
		} else {
			idMotorista = null;
		}
	}
	
	/**
	 * Grava alterações da solicitação na base de dados
	 */
	public void salvarSolicitacao() {
		Motorista motorista = motoristaDAO.find(idMotorista);
		
		solicitacao.setMotorista(motorista);
		
		Solicitacao update = solicitacaoDAO.update(solicitacao);
		
		if(update != null) {
			//RequestContext.getCurrentInstance().execute("PF('dlgLogin').hide();");
			PrimeFaces.current().executeScript("PF('dlgSolicitacao').hide();");
			UtilJSF.msgInformacao("Solicitação "  + update.getId() + " alterada com sucesso!");
		}
		
	}
		
	public List<Solicitacao> getListaSolicitacoes() {
		return listaSolicitacoes;
	}

	public void setListaSolicitacoes(List<Solicitacao> listaSolicitacoes) {
		this.listaSolicitacoes = listaSolicitacoes;
	}

	public Solicitacao getSolicitacao() {
		return solicitacao;
	}

	public void setSolicitacao(Solicitacao solicitacao) {
		this.solicitacao = solicitacao;
	}

	public List<SelectItem> getSelectMotorista() {
		return selectMotorista;
	}

	public void setSelectMotorista(List<SelectItem> selectMotorista) {
		this.selectMotorista = selectMotorista;
	}

	public Long getIdMotorista() {
		return idMotorista;
	}

	public void setIdMotorista(Long idMotorista) {
		this.idMotorista = idMotorista;
	}

	
}
