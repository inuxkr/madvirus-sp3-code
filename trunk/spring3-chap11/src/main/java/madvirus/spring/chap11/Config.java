package madvirus.spring.chap11;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "config")
public class Config {

	@XmlElement(name = "server")
	private List<ServerConfig> serverConfigs;

	public List<ServerConfig> getServerConfigs() {
		return serverConfigs;
	}

	public void setServerConfigs(List<ServerConfig> serverConfigs) {
		this.serverConfigs = serverConfigs;
	}

}
