package kame.spring.chap05.aop.pojo;

import kame.spring.chap05.member.service.UpdateInfo;

import org.aspectj.lang.JoinPoint;

public class UpdateMemberInfoTraceAdvice {

	public void traceReturn(JoinPoint joinPoint, boolean result,
			String memberId, UpdateInfo info) {
		System.out.println("[TA] 정보 수정: 결과=" + result + ",대상회원=" + memberId
				+ ",수정정보=" + info);
	}

}
