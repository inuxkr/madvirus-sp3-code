package madvirus.spring.chap13;

import javax.mail.MessagingException;
import javax.mail.Message.RecipientType;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;

public class MimeRegistrationNotifier implements RegistrationNotifier {

	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendEmail(Member member) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			message.setSubject("[Mime] ȸ�� ���� �ȳ�", "euc-kr");
			String htmlContent = "<strong>�ȳ��ϼ���</strong>, �ݰ����ϴ�.";
			message.setText(htmlContent, "euc-kr", "html");
			message.setFrom(new InternetAddress("madvirus@wemade.com"));
			message.addRecipient(RecipientType.TO, new InternetAddress(member
					.getEmail()));
		} catch (MessagingException e) {
			// ���� ó��
			e.printStackTrace();
			return;
		}
		try {
			mailSender.send(message);
		} catch (MailException e) {
			// ���� ó��
			e.printStackTrace();
		}
	}

}
