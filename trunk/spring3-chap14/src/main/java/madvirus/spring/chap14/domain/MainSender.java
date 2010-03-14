package madvirus.spring.chap14.domain;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainSender {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"sender.xml");
		ArticleMessageSender messageSender = context
				.getBean(ArticleMessageSender.class);
		Article article = new Article("주제" + System.currentTimeMillis());
		messageSender.sendMessage(article);
		System.out.println("메시지 보냄: " + article.getSubject());
	}
}
