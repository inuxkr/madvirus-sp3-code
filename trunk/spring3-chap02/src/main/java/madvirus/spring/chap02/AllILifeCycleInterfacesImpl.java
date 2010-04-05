package madvirus.spring.chap02;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

public class AllILifeCycleInterfacesImpl implements BeanNameAware,
		BeanFactoryAware, InitializingBean, DisposableBean,
		ResourceLoaderAware, ApplicationEventPublisherAware,
		MessageSourceAware, ApplicationContextAware {

	public AllILifeCycleInterfacesImpl() {
		System.out.println("AllILifeCycleInterfacesImpl.»ý¼ºÀÚ()");
	}
	
	@Override
	public void setBeanName(String arg0) {
		System.out.println("AllILifeCycleInterfacesImpl.setBeanName()");
	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		System.out.println("AllILifeCycleInterfacesImpl.setBeanFactory()");
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("AllILifeCycleInterfacesImpl.afterPropertiesSet()");
	}

	@Override
	public void destroy() throws Exception {
		System.out.println("AllILifeCycleInterfacesImpl.destroy()");
	}

	@Override
	public void setResourceLoader(ResourceLoader arg0) {
		System.out.println("AllILifeCycleInterfacesImpl.setResourceLoader()");
	}

	@Override
	public void setApplicationEventPublisher(ApplicationEventPublisher arg0) {
		System.out.println("AllILifeCycleInterfacesImpl.setApplicationEventPublisher()");
	}

	@Override
	public void setMessageSource(MessageSource arg0) {
		System.out.println("AllILifeCycleInterfacesImpl.setMessageSource()");
	}

	@Override
	public void setApplicationContext(ApplicationContext arg0)
			throws BeansException {
		System.out.println("AllILifeCycleInterfacesImpl.setApplicationContext()");
	}
	
	public void customInit() {
		System.out.println("AllILifeCycleInterfacesImpl.customInit()");
	}

	@PostConstruct
	public void annotatedInit() {
		System.out.println("AllILifeCycleInterfacesImpl.annotatedInit()");
	}

	@PreDestroy
	public void annotatedDestroy() {
		System.out.println("AllILifeCycleInterfacesImpl.annotatedDestroy()");
	}

	public void customDestroy() {
		System.out.println("AllILifeCycleInterfacesImpl.customDestroy()");
	}
}
