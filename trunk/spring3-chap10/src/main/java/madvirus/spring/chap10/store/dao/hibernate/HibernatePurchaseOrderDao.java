package madvirus.spring.chap10.store.dao.hibernate;

import madvirus.spring.chap10.store.dao.PurchaseOrderDao;
import madvirus.spring.chap10.store.domain.PurchaseOrder;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HibernatePurchaseOrderDao implements PurchaseOrderDao {

	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void insert(PurchaseOrder order) {
		sessionFactory.getCurrentSession().save(order);
	}

}
