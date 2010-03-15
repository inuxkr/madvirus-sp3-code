package madvirus.spring.chap08.service;

import java.util.Collections;
import java.util.Date;
import java.util.List;

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
		int totalCount = guestMessageDao.count();
		if (totalCount == 0) {
			return new GuestMessageList(0, 0, 0, 0, Collections
					.<GuestMessage> emptyList());
		}
		int begin = (pageNum - 1) * pageSize + 1;
		int end = begin + pageSize - 1;
		if (end > totalCount) {
			end = totalCount;
		}
		List<GuestMessage> messages = guestMessageDao.select(begin, end);
		return new GuestMessageList(totalCount, pageNum, begin, end, messages);
	}

	@Autowired
	public void setGuestMessageDao(GuestMessageDao guestMessageDao) {
		this.guestMessageDao = guestMessageDao;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

}
