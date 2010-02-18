package madvirus.spring.chap09.atomikos;

import com.atomikos.jdbc.AtomikosDataSourceBean;
import com.mysql.jdbc.jdbc2.optional.MysqlXADataSource;

public class AtomikosDataSourceBeanTest {

	public void test() {
		AtomikosDataSourceBean ds = new AtomikosDataSourceBean();
//		ds.setBorrowConnectionTimeout(borrowConnectionTimeout);
//		ds.setMaxPoolSize(maxPoolSize);
//		ds.setMinPoolSize(minPoolSize);
//		ds.setPoolSize(poolSize);
//		ds.setTestQuery(testQuery)
//		ds.setMaxIdleTime(maxIdleTime)
//		ds.setMaintenanceInterval(maintenanceInterval);
//		ds.setReapTimeout(reapTimeout)
		MysqlXADataSource mds = new MysqlXADataSource();
		mds.setUrl("");
		mds.setUser("");
		mds.setPassword("");
	}
}
