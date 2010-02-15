package madvirus.spring.chap09.store.dao.ibatis;

import madvirus.spring.chap09.store.dao.PaymentInfoDao;
import madvirus.spring.chap09.store.domain.PaymentInfo;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class IBatisPaymentInfoDao extends SqlMapClientDaoSupport implements
		PaymentInfoDao {

	@Override
	public void insert(PaymentInfo paymentInfo) {
		getSqlMapClientTemplate().insert("PaymentInfo.insert", paymentInfo);
	}

}
