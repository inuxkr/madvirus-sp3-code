package madvirus.spring.chap06.service;

public class MockAuthenticator implements Authenticator {

	@Override
	public void authenticate(LoginCommand loginCommand)
			throws AuthenticationException {
		if (!loginCommand.getUserId().equals(loginCommand.getPassword())) {
			throw new AuthenticationException();
		}
	}

}
