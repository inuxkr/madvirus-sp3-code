package madvirus.spring.chap10.store.dao.ibatis;

import madvirus.spring.chap10.store.dao.ItemDao;
import madvirus.spring.chap10.store.domain.Item;

import org.springframework.orm.ibatis.SqlMapClientTemplate;

public class IBatisItemDao implements ItemDao {

	private SqlMapClientTemplate sqlMapClientTemplate;

	public void setSqlMapClientTemplate(
			SqlMapClientTemplate sqlMapClientTemplate) {
		this.sqlMapClientTemplate = sqlMapClientTemplate;
	}

	@Override
	public Item findById(Integer itemId) {
		return (Item) sqlMapClientTemplate.queryForObject("Item.findById",
				itemId);
	}

}
