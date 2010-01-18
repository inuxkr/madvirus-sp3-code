package madvirus.spring.chap06.converting;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import madvirus.spring.chap06.model.GuestMessage;
import madvirus.spring.chap06.model.GuestMessageList;

import org.codehaus.jackson.JsonEncoding;
import org.codehaus.jackson.JsonGenerator;
import org.codehaus.jackson.map.ObjectMapper;
import org.junit.Test;

public class ObjectMapperTest {

	@Test
	public void test() throws IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		JsonEncoding encoding = JsonEncoding.UTF8;
		JsonGenerator jsonGenerator = objectMapper.getJsonFactory()
				.createJsonGenerator(System.out, encoding);

		GuestMessageList messageList = new GuestMessageList();
		List<GuestMessage> messages = new ArrayList<GuestMessage>();
		messages.add(new GuestMessage(1, "메시지", new Date()));
		messages.add(new GuestMessage(2, "message", new Date()));
		messageList.setMessages(messages);

		objectMapper.writeValue(jsonGenerator, messageList);

		String src = "{\"creationTime\":1263624100646,\"message\":\"최범균\",\"id\":1}";
		GuestMessage m = objectMapper.readValue(new StringReader(src),
				GuestMessage.class);
		System.out.println();
		System.out.println();
		System.out.println(m);
	}
}
