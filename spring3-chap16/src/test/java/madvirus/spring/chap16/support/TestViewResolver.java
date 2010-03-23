package madvirus.spring.chap16.support;

import java.util.Locale;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

public class TestViewResolver implements ViewResolver {

	@Override
	public View resolveViewName(final String viewName, Locale locale)
			throws Exception {
		return new View() {
			public String getContentType() {
				return null;
			}

			@SuppressWarnings( { "unchecked" })
			public void render(Map model, HttpServletRequest request,
					HttpServletResponse response) throws Exception {
				response.getWriter().write(viewName);
			}
		};
	}
}
