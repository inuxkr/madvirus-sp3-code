package madvirus.spring.chap08.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Date;
import java.util.List;

import madvirus.spring.chap08.model.GuestMessage;

public class MessageDaoTestHelper {

	public void test(GuestMessageDao guestMessageDao) {
		int count1 = guestMessageDao.count();

		GuestMessage firstMsg = makeGuestMessage("손님1", "내용1");
		int insert = guestMessageDao.insert(firstMsg);
		assertEquals(1, insert);
		System.out.println("추가된 메시지 ID = " + firstMsg.getId());
		assertTrue(firstMsg.getId() > 0);

		int count2 = guestMessageDao.count();
		assertEquals(count1 + 1, count2);

		List<GuestMessage> list = guestMessageDao.select(1, count2);
		assertEquals(count2, list.size());
		for (GuestMessage msg : list) {
			assertTrue(msg.getId() > 0);
			assertFalse(msg.getGuestName().isEmpty());
			assertFalse(msg.getMessage().isEmpty());
			assertTrue(msg.getRegistryDate() != null);
		}

	}

	private GuestMessage makeGuestMessage(String guestName, String message) {
		GuestMessage msg = new GuestMessage();
		msg.setGuestName(guestName);
		msg.setMessage(message);
		msg.setRegistryDate(new Date());
		return msg;
	}
}
