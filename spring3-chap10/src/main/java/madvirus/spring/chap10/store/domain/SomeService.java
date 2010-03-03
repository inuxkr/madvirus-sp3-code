package madvirus.spring.chap10.store.domain;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;

public class SomeService {

	@PersistenceUnit
	private EntityManagerFactory emf;
	
	public void some() {
		EntityManager entityManager = emf.createEntityManager();
		System.out.println(emf);
		entityManager.close();
	}
}
