package madvirus.spring.appb;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String[] configLocations = new String[] { "applicationContext.xml" };
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);
		context.registerShutdownHook();
		
		MailSender mailSender = context.getBean("mailSender", MailSender.class);
		mailSender.sendMail("ÃÖ¹ü±Õ");	
	}
}
