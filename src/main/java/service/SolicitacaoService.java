package service;

import java.time.LocalDateTime;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.inject.Inject;

import dao.SolicitacaoDAO;
import enums.StatusSolicitacao;
import model.Solicitacao;

@Local
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class SolicitacaoService {

	@Inject
	private SolicitacaoDAO solicitacaoDAO;
	
	public Solicitacao salvarSolicitacao(Solicitacao solicitacao) throws Exception {
		solicitacao.setDateCadastro(LocalDateTime.now());
		solicitacao.setStatus(StatusSolicitacao.PENDENTE);
		return solicitacaoDAO.save(solicitacao);
	}

	public Solicitacao obterSolicitacaoPorID(long id) {
		return solicitacaoDAO.find(id);
	}

	public List<Solicitacao> obterListaSolicitacao() {
		return solicitacaoDAO.findAll();
	}

}
