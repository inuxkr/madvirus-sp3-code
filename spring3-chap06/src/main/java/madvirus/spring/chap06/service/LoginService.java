package madvirus.spring.chap06.service;

public interface LoginService {

	boolean authenticate(LoginCommand loginCommand);
	
}
