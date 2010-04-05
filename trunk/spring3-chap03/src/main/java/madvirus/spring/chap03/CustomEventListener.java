package madvirus.spring.chap03;

import org.springframework.context.ApplicationListener;

public class CustomEventListener implements
		ApplicationListener<MemberRegistrationEvent> {

	@Override
	public void onApplicationEvent(MemberRegistrationEvent event) {
		System.out.println("회원 가입 이벤트 발생: " + event.getMember());
	}

}
