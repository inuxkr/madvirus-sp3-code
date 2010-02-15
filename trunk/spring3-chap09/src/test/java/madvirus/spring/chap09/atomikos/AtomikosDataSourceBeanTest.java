package madvirus.spring.chap09.atomikos;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

public class AtomikosDataSourceBeanTest {

	public void test() {
		AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
//		ds.setReapTimeout(reapTimeout)
		MysqlXADataSource mds = new MysqlXADataSource();
		mds.setUrl("");
		mds.setUser("");
		mds.setPassword("");
	}
}
