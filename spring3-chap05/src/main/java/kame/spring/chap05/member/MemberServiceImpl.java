package kame.spring.chap05.member;

public class MemberServiceImpl implements MemberService {

	@Override
	public void regist(Member member) {
        System.out.println("MemberServiceImpl.regist() 메서드 실행");
	}

}
