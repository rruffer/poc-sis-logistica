package dao;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

@Transactional(rollbackOn = Exception.class)
public abstract class AbstractDAO<T, PK> implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4212686475276199372L;
	private static final Logger log = Logger.getLogger("AbstractDAO");
	/**
	 * 
	 */
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private transient EntityManager em;
	private final Class<T> classe;

	public EntityManager entityManager() {
		return em;
	}

	@SuppressWarnings("unchecked")
	public AbstractDAO() {
		classe = DetectClass.getEntityClass(getClass());
	}

	public T save(T object) {
		em.persist(object);
		
		return object;
	}

	public List<T> findAll() {
		String oql = "select c from " + classe.getSimpleName() + " c ";
		return findByOQL(oql);
	}

	public List<T> findAll(List<String> filtros) {
		throw new UnsupportedOperationException("Nao implementado");
	}

	public List<T> findByOQL(String oql, Object... pars) {
		TypedQuery<T> qry = em.createQuery(oql, classe);
		int x = 0;
		for (Object o : pars) {
			qry.setParameter(++x, o);
		}
		return qry.getResultList();
	}

	public T findByOQLUnique(String oql, Object... pars) {
		try {
			TypedQuery<T> qry = em.createNamedQuery(oql, classe);
			int x = 0;
			for (Object o : pars) {
				qry.setParameter(++x, o);
			}
			qry.setMaxResults(1);
			return qry.getSingleResult();
		} catch (NoResultException e) {
			log.log(Level.SEVERE, "Exception na rotina findByOQLUnique.", e);
			return null;
		}
	}
	
	public T findByTeste(String oql, Object... pars) {
		try {
			TypedQuery<T> qry = em.createNamedQuery(oql, classe);
			int x = 0;
			for (Object o : pars) {
				qry.setParameter(++x, o);
			}
			qry.setMaxResults(1);
			return qry.getSingleResult();
		} catch (NoResultException e) {
			log.log(Level.SEVERE, "Exception na rotina findByOQLUnique.", e);
			return null;
		}
	}

	public T update(T object) {
		return em.merge(object);
	}

	public void remove(T object) {
		em.remove(object);
	}

	public void refresh(T object) {
		em.refresh(object);
	}

	public void flush() {
		em.flush();
	}

	public T find(PK pk) {
		return em.find(classe, pk);
	}

}
