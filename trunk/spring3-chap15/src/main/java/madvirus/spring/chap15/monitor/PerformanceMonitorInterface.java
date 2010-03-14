package madvirus.spring.chap15.monitor;

public interface PerformanceMonitorInterface {

	int getViewCount();

	long getSumOfResponseTime();

	double getAverageResponseTime();

	void increaseViewCount(long responseTime);

	void reset();
}
