package madvirus.spring.chap03;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;

public class LoginProcessor implements MessageSourceAware {

	private MessageSource messageSource;

	@Override
	public void setMessageSource(MessageSource messageSource) {
		this.messageSource = messageSource;
	}

	public void login(String username, String password) {
		if (!username.equals("madvirus")) {
			Object[] args = new String[] { username };
			String failMessage = messageSource.getMessage("login.fail", args,
					Locale.getDefault());
			throw new IllegalArgumentException(failMessage);
		}
	}

}
