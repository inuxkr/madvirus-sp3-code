package madvirus.spring.chap12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.SchedulingTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		ThreadPoolTaskExecutor executor = context.getBean("executor", ThreadPoolTaskExecutor.class);
		executor.execute(new SyncWork());
		executor.execute(new SyncWork());
		executor.execute(new SyncWork(), 300);
		System.out.println("작업 전송");
		
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		context.destroy();
		context.close();
	}
	
	public static class SyncWork implements Runnable {

		@Override
		public void run() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("SynWork 실행");
		}
		
	}
}
