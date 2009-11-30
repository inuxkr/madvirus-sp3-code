package kame.spring.chap05.aop.pojo;

import kame.spring.chap05.member.service.UpdateInfo;

import org.aspectj.lang.JoinPoint;

public class UpdateMemberInfoTraceAdvice {

	public void traceReturn(JoinPoint joinPoint, boolean result,
			String memberId, UpdateInfo info) {
		System.out.println("[TA] ���� ����: ���=" + result + ",���ȸ��=" + memberId
				+ ",��������=" + info);
	}

}
