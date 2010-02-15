package madvirus.spring.chap09.store.dao.hibernate;

import madvirus.spring.chap09.store.dao.ItemDao;
import madvirus.spring.chap09.store.domain.Item;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateItemDao extends HibernateDaoSupport implements ItemDao {

	@Override
	public Item findById(Integer itemId) {
		return (Item) getHibernateTemplate().get(Item.class, itemId);
	}

}
