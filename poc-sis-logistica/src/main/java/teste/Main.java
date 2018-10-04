package teste;

import javax.persistence.EntityManager;

import util.JPAUtil;

public class Main {

	public static void main(String[] args) {
		EntityManager manager = JPAUtil.getEntityManager();
		//Persistence.createEntityManagerFactory("logistica");
	}
	
}
