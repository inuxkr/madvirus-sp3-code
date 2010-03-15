package madvirus.spring.chap16.dao;

import java.util.List;

import madvirus.spring.chap16.model.GuestMessage;

public interface GuestMessageDao {

	public int count();
	
	public List<GuestMessage> select(int begin, int end);
	
	public int insert(GuestMessage message);
	
	public int delete(int id);
	
	public int update(GuestMessage message);
}
