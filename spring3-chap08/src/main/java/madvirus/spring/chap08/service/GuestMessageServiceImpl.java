package madvirus.spring.chap08.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import madvirus.spring.chap08.dao.GuestMessageDao;
import madvirus.spring.chap08.model.GuestMessage;
import madvirus.spring.chap08.model.GuestMessageList;

public class GuestMessageServiceImpl implements GuestMessageService {

	public static final int DEFAULT_PAGE_SIZE = 20;

	private int pageSize = DEFAULT_PAGE_SIZE;
	private GuestMessageDao guestMessageDao;

	@Transactional
	public GuestMessage write(GuestMessage message) {
		message.setRegistryDate(new Date());
		guestMessageDao.insert(message);
		return message;
	}

	@Transactional
	public GuestMessageList getMessageList(int pageNum) {
		
		return new GuestMessageList();
	}

	@Autowired
	public void setGuestMessageDao(GuestMessageDao guestMessageDao) {
		this.guestMessageDao = guestMessageDao;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
