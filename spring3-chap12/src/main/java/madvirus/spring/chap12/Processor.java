package madvirus.spring.chap12;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

public class Processor {

	private ThreadPoolTaskExecutor executor;

	public void setExecutor(ThreadPoolTaskExecutor executor) {
		this.executor = executor;
	}

	public void process(final Work work) {
		Future<?> future = executor.submit(new Runnable() {
			@Override
			public void run() {
				work.run();
			}

		});
		try {
			future.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return;
	}
}
