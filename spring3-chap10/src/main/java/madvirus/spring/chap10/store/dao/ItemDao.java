package madvirus.spring.chap10.store.dao;

import madvirus.spring.chap10.store.domain.Item;

public interface ItemDao {

	Item findById(Integer itemId);

}
