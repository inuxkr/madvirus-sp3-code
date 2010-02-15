package madvirus.spring.chap09.store.dao;

import madvirus.spring.chap09.store.domain.Item;

public interface ItemDao {

	Item findById(Integer itemId);

}
