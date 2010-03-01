package madvirus.spring.chap10.store.dao.hibernate;

import madvirus.spring.chap10.store.dao.ItemDao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/hibernate-conf.xml")
@TransactionConfiguration(defaultRollback = false)
public class HibernateDaoExceptionTranslationTest {

	@Autowired
	private ItemDao itemDao;
	
	@Test
	public void test() {
		itemDao.findById(10);
	}
}
