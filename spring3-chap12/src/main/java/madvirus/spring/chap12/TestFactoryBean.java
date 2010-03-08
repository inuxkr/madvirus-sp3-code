package madvirus.spring.chap12;

import org.springframework.beans.factory.FactoryBean;

public class TestFactoryBean implements FactoryBean<Test> {

	@Override
	public Test getObject() throws Exception {
		return new Test();
	}

	@Override
	public Class<?> getObjectType() {
		return Test.class;
	}

	@Override
	public boolean isSingleton() {
		return true;
	}

}
