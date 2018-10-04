package util;

import java.lang.reflect.Type;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

public abstract class JpaDAO<T> implements GenericDAO<T> {
	protected Class<T> persistentClass;
	private EntityManager manager;

	public JpaDAO() {
		Type tipo = ((java.lang.reflect.ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		this.persistentClass = ((Class) tipo);

		this.manager = JPAUtil.getEntityManager();
	}

	public JpaDAO(EntityManager manager) {
		this();
		this.manager = manager;
	}

	public EntityManager getEntityManager() {
		if ((this.manager != null) && (!this.manager.isOpen())) {
			this.manager = JPAUtil.getEntityManager();
		}
		return this.manager;
	}

	public T lerPorId(Object id) {
		return (T) getEntityManager().find(this.persistentClass, id);
	}

	public List<T> lerTodos() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<T> c = cb.createQuery(this.persistentClass);
		c.select(c.from(this.persistentClass));

		List<T> resultado = getEntityManager().createQuery(c).getResultList();
		return resultado;
	}

	public T salvar(T objeto) {
		boolean transacaoAtiva = getEntityManager().getTransaction().isActive();

		if (!transacaoAtiva) {
			abrirTransacao();
		}
		getEntityManager().merge(objeto);

		if (!transacaoAtiva) {
			gravarTransacao();
		}
		return objeto;
	}

	public void excluir(T objeto) {
		boolean transacaoAtiva = getEntityManager().getTransaction().isActive();

		if (!transacaoAtiva) {
			abrirTransacao();
		}
		getEntityManager().remove(objeto);

		if (!transacaoAtiva) {
			gravarTransacao();
		}
	}

	public void abrirTransacao() {
		getEntityManager().getTransaction().begin();
	}

	public void gravarTransacao() {
		getEntityManager().flush();
		getEntityManager().getTransaction().commit();
	}

	public void desfazerTransacao() {
		getEntityManager().getTransaction().rollback();
	}
}
