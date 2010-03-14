package madvirus.spring.chap15.monitor;

public interface ManagerPerformanceMonitor {

	void increaseViewCount(long responseTime);

	int getViewCount();

	void setViewCount();

}
