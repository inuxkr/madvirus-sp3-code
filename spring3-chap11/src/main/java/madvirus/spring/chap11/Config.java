package madvirus.spring.chap11;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "config")
public class Config {

	@XmlAttribute
	private String description;

	@XmlElement(name = "server-list")
	private ServerConfigList serverConfigList;

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ServerConfigList getServerConfigList() {
		return serverConfigList;
	}

	public void setServerConfigList(ServerConfigList serverConfigList) {
		this.serverConfigList = serverConfigList;
	}

}
