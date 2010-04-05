package kame.spring.chap02;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainHierachy {
	public static void main(String[] args) {
		String[] parentConfigLocations = new String[] { "applicationContextParent.xml" };
		AbstractApplicationContext parentContext = new ClassPathXmlApplicationContext(
				parentConfigLocations);

		String[] childConfigLocations = new String[] { "applicationContextChild.xml" };
		AbstractApplicationContext childContext = new ClassPathXmlApplicationContext(
				childConfigLocations, parentContext);

		SmsSender parentSender = parentContext.getBean("smsSender",
				SmsSender.class);
		SmsSender childSender = childContext.getBean("smsSender",
				SmsSender.class);

		System.out.println("parentSender == childSender : "
				+ (parentSender == childSender));
		SystemMonitor monitor = childContext.getBean("monitor",
				SystemMonitor.class);
		System.out.println(monitor);
	}

}
