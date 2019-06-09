package transaction;

import java.time.LocalDateTime;

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
public class SolicitacaoTransaction {

	@Inject
	private SolicitacaoDAO solicitacaoDAO;
	
	public Solicitacao salvarSolicitacao(Solicitacao solicitacao) throws Exception {
		solicitacao.setDateCadastro(LocalDateTime.now());
		solicitacao.setStatus(StatusSolicitacao.PENDENTE);
		return solicitacaoDAO.save(solicitacao);
	}

}
