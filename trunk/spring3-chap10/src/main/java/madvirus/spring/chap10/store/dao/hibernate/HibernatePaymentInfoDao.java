package madvirus.spring.chap10.store.dao.hibernate;

import madvirus.spring.chap10.store.dao.PaymentInfoDao;
import madvirus.spring.chap10.store.domain.PaymentInfo;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HibernatePaymentInfoDao implements PaymentInfoDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(PaymentInfo paymentInfo) {
		sessionFactory.getCurrentSession().save(paymentInfo);
	}

}
