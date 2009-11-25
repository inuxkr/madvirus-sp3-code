package kame.spring.chap05.aop.pojo;

import org.aspectj.lang.ProceedingJoinPoint;

public class PerformanceTraceAdvice {

	public Object trace(ProceedingJoinPoint joinPoint) throws Throwable {
		long start = System.currentTimeMillis();
		try {
			Object result = joinPoint.proceed();
			return result;
		} finally {
			long finish = System.currentTimeMillis();
			System.out.println(joinPoint.getSignature().getName() + ": "
					+ (finish - start));
		}
	}
}
