package kame.spring.chap05.aop.pojo;

import org.aspectj.lang.JoinPoint;

public class LoggingAdviceWithParam {

	public void before(JoinPoint joinPoint) {
		System.out.println("[LAWP] 메서드 실행 전 전처리 수행:"
				+ joinPoint.getSignature().getDeclaringTypeName());
	}

	public void afterReturning(JoinPoint joinPoint, Object ret) {
		System.out.println("[LAWP] 메서드 실행 후 후처리 수행, 리턴값=" + ret);
	}

	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		System.out.println("[LAWP] 메서드 실행 중 예외 발생, 예외=" + ex.getMessage());
	}

	public void afterFinally(JoinPoint joinPoint) {
		System.out.println("[LAWP] 메서드 실행 완료");
	}

}
