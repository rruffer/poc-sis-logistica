package dao;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import model.Autenticacao;
import model.TipoEsquema;

@Named
public class AutenticacaoDAO extends AbstractDAO<Autenticacao, Long> {

	private static final long serialVersionUID = -6982233927213571947L;

	public Autenticacao obterAutenticacao(String usuario, String senha) {

		TypedQuery<Autenticacao> query = entityManager().createNamedQuery(Autenticacao.SEARCH_AUT, Autenticacao.class);
		query.setParameter("usuario", usuario);
		query.setParameter("senha", senha);

		return query.getSingleResult();

	}

	public Autenticacao obterAutenticacao(TipoEsquema esquema) {
		TypedQuery<Autenticacao> query = entityManager().createNamedQuery(Autenticacao.SEARCH_AUT_ESQUEMA, Autenticacao.class);
		query.setParameter("esquema", esquema);
		
		return query.getSingleResult();
	}

}
