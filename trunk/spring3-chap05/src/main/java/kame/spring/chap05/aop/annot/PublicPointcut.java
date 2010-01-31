package kame.spring.chap05.aop.annot;

import org.aspectj.lang.annotation.Pointcut;

public class PublicPointcut {

	@Pointcut("execution(public * kame.spring.chap05..*(..))")
	public void publicMethod() { }
}