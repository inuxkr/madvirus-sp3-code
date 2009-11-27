package kame.spring.chap05.aop.pojo;

import org.aspectj.lang.JoinPoint;

public class LoggingAdviceWithParam {

	public void before(JoinPoint joinPoint) {
		System.out.println("[LAWP] �޼��� ���� �� ��ó�� ����:"
				+ joinPoint.getSignature().getDeclaringTypeName());
	}

	public void afterReturning(JoinPoint joinPoint, Object ret) {
		System.out.println("[LAWP] �޼��� ���� �� ��ó�� ����, ���ϰ�=" + ret);
	}

	public void afterThrowing(JoinPoint joinPoint, Throwable ex) {
		System.out.println("[LAWP] �޼��� ���� �� ���� �߻�, ����=" + ex.getMessage());
	}

	public void afterFinally(JoinPoint joinPoint) {
		System.out.println("[LAWP] �޼��� ���� �Ϸ�");
	}

}
