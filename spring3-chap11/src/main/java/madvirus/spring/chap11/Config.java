package madvirus.spring.chap11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "config")
public class Config {

	@XmlElement(name = "server-list")
	private ServerConfigList serverConfigList;

	public ServerConfigList getServerConfigList() {
		return serverConfigList;
	}

	public void setServerConfigList(ServerConfigList serverConfigList) {
		this.serverConfigList = serverConfigList;
	}

}
