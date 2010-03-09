package madvirus.spring.chap12;

import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;

public class Main {

	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		Processor processor = context.getBean(Processor.class);
		processor.process(new Work());
		System.out.println("�۾� ���� ��");

		ThreadPoolTaskScheduler scheduler = context.getBean("scheduler",
				ThreadPoolTaskScheduler.class);

		Calendar calendar = Calendar.getInstance();
		calendar.add(Calendar.SECOND, 5);
		scheduler.schedule(new Runnable() {

			@Override
			public void run() {
				System.out.println("5�� �� ����");
			}

		}, calendar.getTime());

		scheduler.scheduleAtFixedRate(new Runnable() {

			@Override
			public void run() {
				System.out.println("���� ���� ����");
			}

		}, 1000);

		CronTrigger trigger = new CronTrigger("0 30 0 * * *");
		scheduler.schedule(new Runnable() {

			@Override
			public void run() {
				System.out.println("2�� ���� ����");
			}

		}, trigger);

		MessageSender sender = context.getBean("messageSender",
				MessageSender.class);
		Future<String> sendFuture = sender.send("�α�");
		try {
			System.out.println("10�� ����");
			Thread.sleep(10000);
			String resultMessage = sendFuture.get();
			System.out.println("��� �޽��� = " + resultMessage);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		context.close();
	}
}
