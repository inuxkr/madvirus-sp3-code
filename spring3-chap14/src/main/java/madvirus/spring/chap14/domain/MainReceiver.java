package madvirus.spring.chap14.domain;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainReceiver {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("receiver.xml");
		ArticleMessageReceiver messageReceiver = context.getBean(ArticleMessageReceiver.class);
		Article article = messageReceiver.receive();
		System.out.println(article.getSubject() + " ¹ÞÀ½");
	}
}