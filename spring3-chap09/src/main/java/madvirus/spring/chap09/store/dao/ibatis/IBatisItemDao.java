package madvirus.spring.chap09.store.dao.ibatis;

import madvirus.spring.chap09.store.dao.ItemDao;
import madvirus.spring.chap09.store.domain.Item;

import org.springframework.orm.ibatis.support.SqlMapClientDaoSupport;

public class IBatisItemDao extends SqlMapClientDaoSupport implements ItemDao {

	@Override
	public Item findById(Integer itemId) {
		return (Item) getSqlMapClientTemplate().queryForObject("Item.findById",
				itemId);
	}

}
