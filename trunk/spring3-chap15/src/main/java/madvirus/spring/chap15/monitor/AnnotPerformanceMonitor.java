package madvirus.spring.chap15.monitor;

import org.springframework.jmx.export.annotation.ManagedAttribute;
import org.springframework.jmx.export.annotation.ManagedOperation;
import org.springframework.jmx.export.annotation.ManagedResource;

@ManagedResource(objectName = "madvirus:name=AnnotMonitor", description = "어노테이션 이용")
public class AnnotPerformanceMonitor {

	private int viewCount;
	private long sumOfResponseTime;
	private double averageResponseTime;

	@ManagedAttribute
	public int getViewCount() {
		return viewCount;
	}

	@ManagedAttribute
	public void setViewCount(int pageView) {
		this.viewCount = pageView;
	}

	@ManagedAttribute
	public double getAverageResponseTime() {
		return averageResponseTime;
	}

	public void setAverageResponseTime(double averageResponseTime) {
		this.averageResponseTime = averageResponseTime;
	}

	@ManagedOperation
	public void increaseViewCount(long responseTime) {
		viewCount++;
		sumOfResponseTime += responseTime;
		averageResponseTime = (double) sumOfResponseTime / (double) viewCount;
	}

	@ManagedOperation
	public void reset() {
		viewCount = 0;
		sumOfResponseTime = 0;
		averageResponseTime = 0.0;
	}
}
