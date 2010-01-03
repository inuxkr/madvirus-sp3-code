package madvirus.spring.chap06.controller;

import madvirus.spring.chap06.service.LoginCommand;
import madvirus.spring.chap06.validator.LoginCommandValidator;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/login/login.do")
public class LoginController {

	private String formViewName = "login/form";
	
	@RequestMapping(method = RequestMethod.GET)
	public String form() {
		return formViewName;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String submit(LoginCommand loginCommand, BindingResult result) {
		new LoginCommandValidator().validate(loginCommand, result);
		if (result.hasErrors()) {
			return formViewName;
		}
		return "redirect:/main.do";
	}
}
