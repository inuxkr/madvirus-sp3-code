package madvirus.spring.chap09.store.dao.hibernate;

import madvirus.spring.chap09.store.dao.PurchaseOrderDao;
import madvirus.spring.chap09.store.domain.PurchaseOrder;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernatePurchaseOrderDao extends HibernateDaoSupport implements
		PurchaseOrderDao {

	@Override
	public void insert(PurchaseOrder order) {
		getHibernateTemplate().save(order);
	}

}
