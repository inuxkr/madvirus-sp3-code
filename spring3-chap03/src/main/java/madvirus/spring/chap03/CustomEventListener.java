package madvirus.spring.chap03;

import org.springframework.context.ApplicationListener;

public class CustomEventListener implements
		ApplicationListener<MemberRegistrationEvent> {

	@Override
	public void onApplicationEvent(MemberRegistrationEvent event) {
		System.out.println("ȸ�� ���� �̺�Ʈ �߻�: " + event.getMember());
	}

}
