package madvirus.spring.chap15.monitor;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClient {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"client.xml");
		MonitorDataReader monitorDataReader = context
				.getBean(MonitorDataReader.class);
		int viewCount = monitorDataReader.getViewCount();
		System.out.println("Á¶È¸¼ö: " + viewCount);

		PerformanceMonitorInterface monitor = context.getBean(
				"performanceMonitor", PerformanceMonitorInterface.class);
		monitor.increaseViewCount(1000);
		
		System.out.println(monitor.getAverageResponseTime() + ":"
				+ monitor.getViewCount());
		context.close();
	}
}
