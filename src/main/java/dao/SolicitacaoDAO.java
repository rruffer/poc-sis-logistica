package dao;

import java.util.List;

import javax.inject.Named;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import enums.StatusSolicitacao;
import model.Solicitacao;

@Named
public class SolicitacaoDAO extends AbstractDAO<Solicitacao, Long> {

	private static final long serialVersionUID = -6982233927213571947L;
	
	public List<Solicitacao> buscarSolicitacoes(StatusSolicitacao status) {

		try {

			TypedQuery<Solicitacao> query = entityManager().createNamedQuery(Solicitacao.SEARCH_SOL, Solicitacao.class);
			query.setParameter("status", "RECEBIDO");

			return query.getResultList();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return null;

	}

}
