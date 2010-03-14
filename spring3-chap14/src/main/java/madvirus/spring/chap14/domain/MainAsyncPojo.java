package madvirus.spring.chap14.domain;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainAsyncPojo {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("receiver-async-pojo.xml");
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		context.close();
	}
}