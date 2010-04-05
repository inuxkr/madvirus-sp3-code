package madvirus.spring.chap03;

import java.util.Locale;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		String[] configLocations = new String[] { "applicationContext.xml" };
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				configLocations);
		context.registerShutdownHook();

		Locale locale = Locale.getDefault();
		String greeting = context.getMessage("greeting", new Object[0], locale);
		System.out.println("Default Locale Greeting: " + greeting);

		Locale englishLocale = Locale.ENGLISH;
		String englishGreeting = context.getMessage("greeting", new Object[0],
				englishLocale);
		System.out.println("English Locale Greeting: " + englishGreeting);

		LoginProcessor loginProcessor = context.getBean("loginProcessor",
				LoginProcessor.class);
		try {
			loginProcessor.login("madvirus2", "1234");
		} catch (Throwable e) {
			System.out.println("예외 발생: " + e.getMessage());
		}

		MemberService memberService = context.getBean("memberService",
				MemberService.class);
		memberService.regist(new Member("madvirus", "최범균"));
	}
}
