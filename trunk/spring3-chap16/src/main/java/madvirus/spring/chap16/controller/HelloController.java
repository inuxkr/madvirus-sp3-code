package madvirus.spring.chap16.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

	@RequestMapping("/hello.do")
	public ModelAndView hello(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("hello");
		mav.addObject("greeting", "æ»≥Á«œººø‰");
		mav.addObject("name", request.getParameter("name"));
		return mav;
	}
}
