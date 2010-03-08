package madvirus.spring.chap12;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.SchedulingTaskExecutor;

public class Main {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");

		SchedulingTaskExecutor executor = context.getBean("executor", SchedulingTaskExecutor.class);
		executor.execute(new SyncWork());
		executor.execute(new SyncWork());
		executor.execute(new SyncWork(), 300);
		System.out.println("작업 전송");
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
