package madvirus.spring.chap06.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import madvirus.spring.chap06.common.CommonLogger;

public class ProfileFilter implements Filter {

	private CommonLogger commonLogger;

	@Override
	public void destroy() {
		commonLogger.log("ProfileFilter.destroy() »£√‚µ ");
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain filterChain) throws IOException, ServletException {
		long start = System.currentTimeMillis();
		try {
			filterChain.doFilter(request, response);
		} finally {
			long finish = System.currentTimeMillis();
			commonLogger.log("Ω««‡ Ω√∞£ : " + (finish - start));
		}
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		commonLogger.log("ProfileFilter.init() »£√‚µ ");
	}

	public void setCommonLogger(CommonLogger commonLogger) {
		this.commonLogger = commonLogger;
	}

}
