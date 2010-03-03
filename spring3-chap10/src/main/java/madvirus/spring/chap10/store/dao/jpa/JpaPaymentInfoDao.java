package madvirus.spring.chap10.store.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import madvirus.spring.chap10.store.dao.PaymentInfoDao;
import madvirus.spring.chap10.store.domain.PaymentInfo;

import org.springframework.stereotype.Repository;

@Repository
public class JpaPaymentInfoDao implements PaymentInfoDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insert(PaymentInfo paymentInfo) {
		entityManager.persist(paymentInfo);
		entityManager.flush();
	}

}
