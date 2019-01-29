package dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.User;
import util.UtilSecurity;

public class UserDAO extends AbstractDAO<User, Integer> {

	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param matricula
	 * @param senha
	 * @return
	 */
	public User buscarUsuario(int matricula, String senha) {

		String senhaCriptografada = UtilSecurity.criptografarSenha(senha);
		
		try {

			TypedQuery<User> query = entityManager().createNamedQuery(User.SEARCH_USER, User.class);
			query.setParameter("matricula", matricula);
			query.setParameter("senha", senhaCriptografada);

			return query.getSingleResult();

		} catch (NoResultException e) {
			// TODO: handle exception
		}

		return null;

	}

}
