package madvirus.spring.chap13;

import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

public class SimpleRegistrationNotifier implements RegistrationNotifier {

	private MailSender mailSender;

	public void setMailSender(MailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendEmail(Member member) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setSubject("회원 가입 안내 [Simple]");
		message.setText("회원 가입을 환영합니다.");
		message.setFrom("madvirus@madvirus.net");
		message.setTo(member.getEmail());
		try {
			mailSender.send(message);
		} catch (MailException ex) {
			// 예외 처리
			ex.printStackTrace();
		}
	}

}
