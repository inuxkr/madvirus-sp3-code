package madvirus.spring.chap09.store.dao.hibernate;

import madvirus.spring.chap09.store.dao.PaymentInfoDao;
import madvirus.spring.chap09.store.domain.PaymentInfo;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

public class HibernatePaymentInfoDao extends HibernateDaoSupport implements
		PaymentInfoDao {

	@Override
	public void insert(PaymentInfo paymentInfo) {
		getHibernateTemplate().save(paymentInfo);
	}

}
