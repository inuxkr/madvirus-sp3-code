package kame.spring.chap05.aop.annot;

import kame.spring.chap05.member.service.UpdateInfo;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class UpdateMemberInfoTraceAspect {

	@AfterReturning(
			pointcut="args(memberId,info)",
			returning="result")
	public void traceReturn(JoinPoint joinPoint, boolean result,
			String memberId, UpdateInfo info) {
		System.out.println("[TA] ���� ����: ���=" + result + ",���ȸ��=" + memberId
				+ ",��������=" + info);
	}

}
