package madvirus.spring.chap10.store.dao.hibernate;

import madvirus.spring.chap10.store.dao.ItemDao;
import madvirus.spring.chap10.store.domain.Item;

import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

@Repository
public class HibernateItemDao implements ItemDao {
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public Item findById(Integer itemId) {
		return (Item) sessionFactory.getCurrentSession()
				.get(Item.class, itemId);
	}

}
