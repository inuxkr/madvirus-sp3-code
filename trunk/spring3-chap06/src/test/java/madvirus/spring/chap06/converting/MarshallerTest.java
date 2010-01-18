package madvirus.spring.chap06.converting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import madvirus.spring.chap06.model.GuestMessage;
import madvirus.spring.chap06.model.GuestMessageList;

import org.junit.Test;

public class MarshallerTest {

	@Test
	public void marshall() throws JAXBException {
		GuestMessageList messageList = new GuestMessageList();
		List<GuestMessage> messages = new ArrayList<GuestMessage>();
		messages.add(new GuestMessage(1, "¸Þ½ÃÁö", new Date()));
		messages.add(new GuestMessage(2, "message", new Date()));
		messageList.setMessages(messages);

		JAXBContext context = JAXBContext.newInstance(GuestMessageList.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(messageList, System.out);
	}
}
