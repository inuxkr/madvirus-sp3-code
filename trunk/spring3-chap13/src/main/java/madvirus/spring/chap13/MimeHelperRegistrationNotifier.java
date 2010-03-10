package madvirus.spring.chap13;

import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeUtility;

import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

public class MimeHelperRegistrationNotifier implements RegistrationNotifier {

	private JavaMailSender mailSender;

	public void setMailSender(JavaMailSender mailSender) {
		this.mailSender = mailSender;
	}

	@Override
	public void sendEmail(Member member) {
		MimeMessage message = mailSender.createMimeMessage();
		try {
			MimeMessageHelper messageHelper = new MimeMessageHelper(message,
					true, "euc-kr");
			messageHelper.setSubject("[Attachment] ȸ�� ���� �ȳ�");
			String htmlContent = "<strong>�ȳ��ϼ���</strong>, �ݰ����ϴ�.";
			messageHelper.setText(htmlContent, true);
			messageHelper.setFrom("madvirus@wemade.com", "�ֹ���");
			messageHelper.setTo(new InternetAddress(member.getEmail(), member
					.getName(), "euc-kr"));

			DataSource dataSource = new FileDataSource("c:\\�ȳ���.docx");
			messageHelper.addAttachment(MimeUtility.encodeText("�ȳ���.docx",
					"euc-kr", "B"), dataSource);
		} catch (Throwable e) {
			e.printStackTrace();
			return;
		}
		try {
			mailSender.send(message);
		} catch (MailException e) {
			e.printStackTrace();
		}
	}

}
