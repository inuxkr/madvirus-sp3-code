package madvirus.spring.chap06.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/test/simpleTest.do")
public class SimpleConverterController {

	
	@RequestMapping(method=RequestMethod.GET)
	public String simpleTestForm() {
		return "test/simpleTestForm";
	}
	
	@RequestMapping(method=RequestMethod.POST)
	@ResponseBody
	public String simpleTest(@RequestBody String body) {
		return body;
	}
}
