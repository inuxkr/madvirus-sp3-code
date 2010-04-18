package madvirus.spring.appb;

import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.ui.velocity.VelocityEngineUtils;

public class MailSender {

	private VelocityEngine velocityEngine;

	public void setVelocityEngine(VelocityEngine engine) {
		this.velocityEngine = engine;
	}

	public void sendMail(String guestName) {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("guestName", guestName);

		String text = VelocityEngineUtils.mergeTemplateIntoString(
				velocityEngine, "template/mail-content.vm", model);
		System.out.println(text);
	}
}
