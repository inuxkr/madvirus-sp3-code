package madvirus.spring.chap12;

import java.util.concurrent.Future;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;

public class MessageSender {

	@Async
	public Future<String> send(String message) {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("메시지 발송: " + message);
		return new AsyncResult<String>(message);
	}
}
