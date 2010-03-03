package madvirus.spring.chap10.store.dao.jpa;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import madvirus.spring.chap10.store.dao.ItemDao;
import madvirus.spring.chap10.store.domain.Item;

import org.springframework.stereotype.Repository;

@Repository
public class JpaItemDao implements ItemDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public Item findById(Integer itemId) {
		return entityManager.find(Item.class, itemId);
	}

}
