package madvirus.spring.chap09.store.dao.ibatis;

import madvirus.spring.chap09.store.dao.PurchaseOrderDao;
import madvirus.spring.chap09.store.domain.PurchaseOrder;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class IBatisPurchaseOrderDao extends SqlMapClientDaoSupport implements
		PurchaseOrderDao {

	@Override
	public void insert(PurchaseOrder order) {
		getSqlMapClientTemplate().insert("PurchaseOrder.insert", order);
	}

}
