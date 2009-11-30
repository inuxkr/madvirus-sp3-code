package kame.spring.chap05.member.service;

import kame.spring.chap05.member.Member;

public class MemberServiceImpl implements MemberService {

	@Override
	public void regist(Member member) {
        System.out.println("MemberServiceImpl.regist() 메서드 실행");
	}

	@Override
	public boolean update(String memberId, UpdateInfo info) {
		System.out.println("MemberServiceImpl.update() 메서드 실행");
		return true;
	}

}
