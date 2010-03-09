package madvirus.spring.chap12;

import org.springframework.scheduling.annotation.Scheduled;

public class LogProcessor {

	@Scheduled(fixedRate = 5000)
	public void process() {
		System.out.println("로그 처리");
	}
}
