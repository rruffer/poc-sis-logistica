package control;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.model.DefaultStreamedContent;
import org.primefaces.model.StreamedContent;

import dao.SolicitacaoDAO;
import enums.StatusSolicitacao;
import model.Solicitacao;
import relatorios.Relatorios;
import relatorios.SolicitacaoRel;
import util.UtilJSF;

/**
 * @link https://arjan-tijms.omnifaces.org/p/jsf-23.html
 * @author rruffer
 *
 */
@Named("relatoriosMB")
@ViewScoped
public class RelatoriosMB implements Serializable {

	private static final long serialVersionUID = 1L;

	@Inject
	FacesContext facesContext;

	@Inject
	private SolicitacaoDAO solicitacaoDAO;
	
	@Inject
	private Relatorios relatorios;

	private List<Solicitacao> listaSolicitacoes;
	private List<Solicitacao> listaTodasSolicitacoes;
	private Integer idRelatorio;
	private LocalDateTime dataInicial;
	private LocalDateTime dataFinal;
	private StatusSolicitacao status;
	
	@PostConstruct
	private void init() {
		
		listaTodasSolicitacoes = solicitacaoDAO.findAll();
		listaSolicitacoes = listaTodasSolicitacoes;
		
	}
	
	public void filtrarSolicitacoes() {
		
		switch (idRelatorio) {
		case 0:
			status = null;
			listaSolicitacoes = listaTodasSolicitacoes;
			//gerarRelatorioExpedicao();
			break;
		case 1:
			status = StatusSolicitacao.RECEBIDO;
			listaSolicitacoes = listaTodasSolicitacoes.stream().filter(s -> s.getStatus() == status).collect(Collectors.toList());
			//gerarRelatorioExpedicao();
			break;
		case 2:
			status = StatusSolicitacao.PENDENTE;
			listaSolicitacoes = listaTodasSolicitacoes.stream().filter(s -> s.getStatus() == status).collect(Collectors.toList());
			//gerarRelatorioExpedicao();
			break;

		default:
			break;
		}
		
	}

	
	/**
	 * Grava alterações da solicitação na base de dados
	 */
	public StreamedContent getArquivo()  {
		
		List<SolicitacaoRel> listSolRel = new ArrayList<>();
		DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		for(Solicitacao s : listaSolicitacoes) {
			
			SolicitacaoRel rel = new SolicitacaoRel();
			rel.setId(s.getId());
			rel.setNomeCliente(s.getCliente().getRazaoSocial());
			
			if(s.getStatus() != null) {
				rel.setStatus(s.getStatus().name());				
			}
			
			if(s.getDateColeta() != null) {
				rel.setDataColeta(s.getDateColeta().format(timeFormatter));				
			}
			
			if(s.getDateEntrega() != null) {
				rel.setDataEntrega(s.getDateEntrega().format(timeFormatter));				
			}
			
			listSolRel.add(rel);
			
		}

		String nomeRelatorio = "relatorio_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy_HH-mm-ss")) + ".pdf";
//		this.file = Relatorios.relatorioExpedicao(listSolRel, nomeRelatorio, status);
//		ByteArrayOutputStream outputStream = Relatorios.relatorioExpedicao(listSolRel, status);
		InputStream inputStream = relatorios.relatorioExpedicao(listSolRel, status);
		
		return new DefaultStreamedContent(inputStream, "application/pdf", nomeRelatorio);
		
	}
	
	
	///////////////////////////////
	//////GETTERS AND SETTERS//////
    ///////////////////////////////
		
	public List<Solicitacao> getListaSolicitacoes() {
		return listaSolicitacoes;
	}

	public void setListaSolicitacoes(List<Solicitacao> listaSolicitacoes) {
		this.listaSolicitacoes = listaSolicitacoes;
	}


	public Integer getIdRelatorio() {
		return idRelatorio;
	}


	public void setIdRelatorio(Integer idRelatorio) {
		this.idRelatorio = idRelatorio;
	}


	public LocalDateTime getDataInicial() {
		return dataInicial;
	}


	public void setDataInicial(LocalDateTime dataInicial) {
		this.dataInicial = dataInicial;
	}


	public LocalDateTime getDataFinal() {
		return dataFinal;
	}


	public void setDataFinal(LocalDateTime dataFinal) {
		this.dataFinal = dataFinal;
	}

	
}
