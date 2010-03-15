package madvirus.spring.chap16.service;

import static org.junit.Assert.assertNotNull;
import madvirus.spring.chap16.dao.GuestMessageDao;
import madvirus.spring.chap16.model.GuestMessage;
import madvirus.spring.chap16.model.GuestMessageList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@TransactionConfiguration(transactionManager = "txMgr", defaultRollback = true)
public class GuestMessageServiceTest {

	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private GuestMessageService guestMessageService;

	@Test
	@Transactional
	@Rollback(false)
	public void write() {
		GuestMessage message = new GuestMessage();
		message.setGuestName("최범균");
		message.setMessage("축하합니다.");
		GuestMessage written = guestMessageService.write(message);
		assertNotNull(written.getId());
	}

	@Test
	@Transactional
	public void list() {
		GuestMessageList messageList = guestMessageService.getMessageList(1);
		assertNotNull(messageList);
	}
	
	@Test
	public void assertDao() {
		GuestMessageDao dao = applicationContext.getBean(GuestMessageDao.class);
		assertNotNull(dao);
	}
}
