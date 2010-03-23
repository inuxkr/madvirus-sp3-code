package madvirus.spring.chap16.support;

import java.util.Map;

import org.junit.Assert;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.support.RootBeanDefinition;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.mock.web.MockServletConfig;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(loader = MockWebContextLoader.class, locations = {
		"/classes/spring.xml", "/springmvc-servlet.xml" })
public abstract class AbstractControllerTestSupport {

	private static DispatcherServlet dispatcherServlet;

	@SuppressWarnings("serial")
	public static DispatcherServlet getServletInstance() {
		try {
			if (null == dispatcherServlet) {
				dispatcherServlet = new DispatcherServlet() {
					protected WebApplicationContext createWebApplicationContext(
							WebApplicationContext parent) {
						GenericWebApplicationContext wac = new GenericWebApplicationContext();
						wac.setParent(MockWebContextLoader.getInstance());
						wac.registerBeanDefinition("viewResolver",
								new RootBeanDefinition(TestViewResolver.class));
						wac.refresh();
						return wac;
					}
				};

				dispatcherServlet.init(new MockServletConfig());
			}
		} catch (Throwable t) {
			Assert.fail("Unable to create a dispatcher servlet: "
					+ t.getMessage());
		}
		return dispatcherServlet;
	}

	protected MockHttpServletRequest mockRequest(String method, String uri,
			Map<String, String> params) {
		MockHttpServletRequest req = new MockHttpServletRequest(method, uri);
		for (String key : params.keySet()) {
			req.addParameter(key, params.get(key));
		}
		return req;
	}

	protected MockHttpServletResponse mockResponse() {
		return new MockHttpServletResponse();
	}
}
