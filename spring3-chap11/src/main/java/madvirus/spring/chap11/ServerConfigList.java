package madvirus.spring.chap11;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class ServerConfigList {

	@XmlElement(name = "server")
	private List<ServerConfig> serverConfigs;

	public ServerConfigList() {
	}

	public ServerConfigList(List<ServerConfig> serverConfigList) {
		this.serverConfigs = serverConfigList;
	}

	public List<ServerConfig> getServerConfigs() {
		return serverConfigs;
	}

	public void setServerConfigs(List<ServerConfig> serverConfigs) {
		this.serverConfigs = serverConfigs;
	}

}
