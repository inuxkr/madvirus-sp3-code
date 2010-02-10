package madvirus.spring.chap08.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import madvirus.spring.chap08.model.GuestMessage;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@TransactionConfiguration(defaultRollback=false)
public class JdbcTemplateGuestMessageDaoTest {

	@Autowired
	private GuestMessageDao guestMessageDao;
	
	@Transactional
	@Test
	public void test() {
		int count1 = guestMessageDao.count();
		
		GuestMessage firstMsg = makeGuestMessage("¼Õ´Ô1", "³»¿ë1");
		int insert = guestMessageDao.insert(firstMsg);
		assertEquals(1, insert);
		assertTrue(firstMsg.getId() > 0);
		
		int count2 = guestMessageDao.count();
		assertEquals(count1+1, count2);
		
		guestMessageDao.select(0, count2);
	}

	private GuestMessage makeGuestMessage(String guestName, String message) {
		GuestMessage msg = new GuestMessage();
		msg.setGuestName(guestName);
		msg.setMessage(message);
		return msg;
	}
}
