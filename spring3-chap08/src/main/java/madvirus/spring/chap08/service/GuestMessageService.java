package madvirus.spring.chap08.service;

import madvirus.spring.chap08.model.GuestMessage;
import madvirus.spring.chap08.model.GuestMessageList;

public interface GuestMessageService {

	GuestMessage write(GuestMessage message);

	GuestMessageList getMessageList(int pageNum);
	
}
