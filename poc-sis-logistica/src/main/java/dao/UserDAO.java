package dao;

import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

import model.User;

public class UserDAO extends AbstractDAO<User, Integer> {

	private static final long serialVersionUID = -6982233927213571947L;
	
	/**
	 * 
	 * @param matricula
	 * @param senha
	 * @return
	 */
	public User buscarUsuario(int matricula, String senha) {
		
		try {
		TypedQuery<User> query = entityManager().createNamedQuery(User.SEARCH_USER, User.class);
		query.setParameter("matricula", matricula);
		query.setParameter("senha", senha);
		
		return query.getSingleResult();
		
		} catch (NoResultException e) {
			// TODO: handle exception
		}
		
		return null;
		
	}

}
