package madvirus.spring.chap16.service;

import madvirus.spring.chap16.model.GuestMessage;
import madvirus.spring.chap16.model.GuestMessageList;

public interface GuestMessageService {

	GuestMessage write(GuestMessage message);

	GuestMessageList getMessageList(int pageNum);

}
