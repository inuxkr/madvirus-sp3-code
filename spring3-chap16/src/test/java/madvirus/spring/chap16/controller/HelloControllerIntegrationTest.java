package madvirus.spring.chap16.controller;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.ModelAndViewAssert;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.ModelAndView;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class HelloControllerIntegrationTest {

	@Autowired
	private ApplicationContext applicationContext;
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private HandlerAdapter handlerAdapter;
	private HelloController controller;
	
	@Before
	public void setup() {
		request = new MockHttpServletRequest();
		response = new MockHttpServletResponse();
		handlerAdapter = applicationContext.getBean(HandlerAdapter.class);
		controller = new HelloController();
	}
	
	@Test
	public void test() throws Exception {
		request.setMethod("GET");
		request.setRequestURI("/hello.do");
		request.addParameter("name", "ÃÖ¹ü±Õ");
		ModelAndView mav = handlerAdapter.handle(request, response, controller);
		ModelAndViewAssert.assertViewName(mav, "hello");
	}
}
