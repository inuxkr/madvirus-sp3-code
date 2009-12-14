package kame.spring.chap05.aop.annot;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class LoggingAspect {

	@Before("PublicPointcut.publicMethod()")
	public void before() {
		System.out.println("[LA] �޼��� ���� �� ��ó�� ����");
	}

	@AfterReturning(
			pointcut = "kame.spring.chap05.aop.annot.PublicPointcut.publicMethod()", 
			returning = "ret")
	public void afterReturning(Object ret) {
		System.out.println("[LA] �޼��� ���� �� ��ó�� ����, ���ϰ�=" + ret);
	}

	@AfterThrowing(
			pointcut = "kame.spring.chap05.aop.annot.PublicPointcut.publicMethod()",
			throwing = "ex")
	public void afterThrowing(Throwable ex) {
		System.out.println("[LA] �޼��� ���� �� ���� �߻�, ����=" + ex.getMessage());
	}

	@After("kame.spring.chap05.aop.annot.PublicPointcut.publicMethod()")
	public void afterFinally() {
		System.out.println("[LA] �޼��� ���� �Ϸ�");
	}

}