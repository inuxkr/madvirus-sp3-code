package madvirus.spring.chap16.controller;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.servlet.ModelAndView;

public class HelloControllerUnitTest {

	@Test
	public void hello() {
		MockHttpServletRequest mockRequest = new MockHttpServletRequest();
		mockRequest.setMethod("POST");
		mockRequest.setCharacterEncoding("euc-kr");
		mockRequest.addParameter("name", "ÃÖ¹ü±Õ");
		HelloController controller = new HelloController();
		ModelAndView mav = controller.hello(mockRequest);
		assertEquals("hello", mav.getViewName());
		assertEquals("ÃÖ¹ü±Õ", mav.getModelMap().get("name"));
	}
}
