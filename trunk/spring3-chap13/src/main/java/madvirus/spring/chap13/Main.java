package madvirus.spring.chap13;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		SimpleRegistrationNotifier simpleNotifier = context.getBean(SimpleRegistrationNotifier.class);
		Member member = new Member("madvirus", "ÃÖ¹ü±Õ", "madvirus@madvirus.net");
		simpleNotifier.sendEmail(member);
		
		MimeRegistrationNotifier mimeNotifier = context.getBean(MimeRegistrationNotifier.class);
		mimeNotifier.sendEmail(member);
		
		MimeHelperRegistrationNotifier helperNotifier = context.getBean(MimeHelperRegistrationNotifier.class);
		helperNotifier.sendEmail(member);
		
		context.close();
	}
}
