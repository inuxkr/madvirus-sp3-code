package madvirus.spring.chap10.store.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import madvirus.spring.chap10.store.dao.PurchaseOrderDao;
import madvirus.spring.chap10.store.domain.PurchaseOrder;

import org.springframework.stereotype.Repository;

@Repository
public class JpaPurchaseOrderDao implements PurchaseOrderDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(PurchaseOrder order) {
		entityManager.persist(order);
		entityManager.flush();
	}

}
