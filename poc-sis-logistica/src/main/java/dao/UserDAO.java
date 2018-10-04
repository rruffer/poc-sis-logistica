package dao;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import model.User;
import util.JpaDAO;

public class UserDAO extends JpaDAO<User> {
	public UserDAO() {
	}

	public UserDAO(EntityManager manager) {
		super(manager);
	}

	public User lerPorLogin(String login) {
		Query consulta = getEntityManager().createQuery("from Usuer u where u.login = :login");
		consulta.setParameter("login", login);
		User resultado;
		try {
			resultado = (User) consulta.getSingleResult();
		} catch (NoResultException e) {
			resultado = null;
		}

		return resultado;
	}
}
