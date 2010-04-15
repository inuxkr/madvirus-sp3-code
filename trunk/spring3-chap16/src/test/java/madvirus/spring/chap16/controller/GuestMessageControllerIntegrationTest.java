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
public class GuestMessageControllerIntegrationTest {

	@Autowired
	private ApplicationContext applicationContext;

	private HandlerAdapter handlerAdapter;
	private GuestMessageController controller;

	@Before
	public void setup() {
		handlerAdapter = applicationContext.getBean(HandlerAdapter.class);
		controller = applicationContext.getBean(GuestMessageController.class);
	}

	@Test
	public void test() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		request.setMethod("GET");
		request.setRequestURI("/message/list/1");
		request.setContextPath("/");
		ModelAndView mav = handlerAdapter.handle(request, response, controller);
		ModelAndViewAssert.assertViewName(mav, "message/list");
	}

}
