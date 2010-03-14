package madvirus.spring.chap15.monitor;

import java.io.IOException;

import javax.management.AttributeNotFoundException;
import javax.management.InstanceNotFoundException;
import javax.management.MBeanException;
import javax.management.MBeanServerConnection;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.ReflectionException;

public class MonitorDataReader {

	private MBeanServerConnection connection;

	public void setConnection(MBeanServerConnection connection) {
		this.connection = connection;
	}

	public int getViewCount() {
		ObjectName mbeanName = null;
		try {
			mbeanName = new ObjectName("madvirus:name=monitor");
		} catch (MalformedObjectNameException e) {
			throw new RuntimeException("invalid name : " + e.getMessage());
		}
		Integer viewCount;
		try {
			viewCount = (Integer) connection.getAttribute(mbeanName,
					"ViewCount");
			return viewCount.intValue();
		} catch (AttributeNotFoundException e) {
			throw new RuntimeException(e);
		} catch (InstanceNotFoundException e) {
			throw new RuntimeException(e);
		} catch (MBeanException e) {
			throw new RuntimeException(e);
		} catch (ReflectionException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
