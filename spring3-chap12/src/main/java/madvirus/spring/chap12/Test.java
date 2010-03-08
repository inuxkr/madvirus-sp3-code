package madvirus.spring.chap12;

import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Test implements InitializingBean, DisposableBean, BeanNameAware {

	private String beanName;

	public Test() {
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println(beanName + " Test.afterPropertiesSet");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println(beanName + " Test.destroy");
	}

	@Override
	public void setBeanName(String name) {
		this.beanName = name;
	}

}
