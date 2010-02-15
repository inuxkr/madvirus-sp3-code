package madvirus.spring.chap08.dao;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
@TransactionConfiguration(defaultRollback=false)
public class GuestMessageDaoTest {

	@Resource(name="jdbcTemplateGuestMessageDao")
	private GuestMessageDao jdbcTemplateGuestMessageDao;
	
	@Resource(name="namedParamGuestMessageDao")
	private GuestMessageDao namedParamGuestMessageDao;
	
	@Resource(name="simpleGuestMessageDao")
	private GuestMessageDao simpleGuestMessageDao;
	
	@Transactional
	@Test
	public void test() {
		new MessageDaoTestHelper().test(jdbcTemplateGuestMessageDao);
		new MessageDaoTestHelper().test(namedParamGuestMessageDao);
		new MessageDaoTestHelper().test(simpleGuestMessageDao);
	}
}
