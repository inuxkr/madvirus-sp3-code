package madvirus.spring.chap15.monitor;

public class PerformanceMonitor {

	private int viewCount;
	private long sumOfResponseTime;
	private double averageResponseTime;

	public int getViewCount() {
		return viewCount;
	}

	public void setViewCount(int pageView) {
		this.viewCount = pageView;
	}

	public long getSumOfResponseTime() {
		return sumOfResponseTime;
	}

	public void setSumOfResponseTime(long sumOfResponseTime) {
		this.sumOfResponseTime = sumOfResponseTime;
	}

	public double getAverageResponseTime() {
		return averageResponseTime;
	}

	public void setAverageResponseTime(double averageResponseTime) {
		this.averageResponseTime = averageResponseTime;
	}

	public void increaseViewCount(long responseTime) {
		viewCount++;
		sumOfResponseTime += responseTime;
		averageResponseTime = (double) sumOfResponseTime / (double) viewCount;
	}

	public void reset() {
		viewCount = 0;
		sumOfResponseTime = 0;
		averageResponseTime = 0.0;
	}
}