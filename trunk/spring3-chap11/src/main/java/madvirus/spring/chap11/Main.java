package madvirus.spring.chap11;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {

	public static void main(String[] args) throws IOException {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"applicationContext.xml");
		ConfigHandler configHandler = context.getBean(ConfigHandler.class);
		Config config = new Config();
		config.setDescription("설명");
		List<ServerConfig> serverConfigs = new ArrayList<ServerConfig>();
		serverConfigs.add(new ServerConfig("localhost", 1024));
		serverConfigs.add(new ServerConfig("central", 1088));
		ServerConfigList serverConfigList = new ServerConfigList(serverConfigs);
		config.setServerConfigList(serverConfigList);
		
		configHandler.save(config, new File("config.xml"));
		
		System.out.println("----");
		
		Config config2 = configHandler.load(new File("config-sample.xml"));
		System.out.println("로딩 결과");
		System.out.println(config2.getDescription());
		for (ServerConfig serverConfig : config2.getServerConfigList().getServerConfigs()) {
			System.out.println(serverConfig);
		}
	}
}
