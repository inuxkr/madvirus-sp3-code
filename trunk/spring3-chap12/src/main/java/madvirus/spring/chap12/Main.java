package madvirus.spring.chap12;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		context.registerShutdownHook();
		
		Processor processor = context.getBean(Processor.class);
		processor.process(new Work());
		System.out.println("작업 실행 됨");
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
