package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JPAUtil {
	private static EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("logistica");

	public static EntityManagerFactory getFactory() {
		return fabrica;
	}

	private static ThreadLocal<EntityManager> CACHE = new ThreadLocal();

	public static void limparCacheEntityManager() {
		EntityManager em = (EntityManager) CACHE.get();

		if (em != null) {
			em.close();
		}
		CACHE.remove();
	}

	public static EntityManager getEntityManager() {
		EntityManager retorno = (EntityManager) CACHE.get();

		if ((retorno != null) && (!retorno.isOpen())) {
			retorno = null;
		}

		if (retorno == null) {
			retorno = fabrica.createEntityManager();

			CACHE.set(retorno);
		}

		return retorno;
	}
}
