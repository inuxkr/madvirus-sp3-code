package kame.spring.chap04.config;

import kame.spring.chap04.homecontrol.AlarmDevice;
import kame.spring.chap04.homecontrol.Camera;
import kame.spring.chap04.homecontrol.DefaultDisplayStrategy;
import kame.spring.chap04.homecontrol.DisplayStrategy;
import kame.spring.chap04.homecontrol.HomeController;
import kame.spring.chap04.homecontrol.InfraredRaySensor;
import kame.spring.chap04.homecontrol.MonitorViewer;
import kame.spring.chap04.homecontrol.Recorder;
import kame.spring.chap04.homecontrol.SmsAlarmDevice;
import kame.spring.chap04.homecontrol.Viewer;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfigAutowired {
	
	@Bean
	public Camera camera1() {
		return new Camera();
	}
	
	@Bean
	public Camera camera2() {
		return new Camera();
	}
	@Bean
	public Camera camera3() {
		return new Camera();
	}
	@Bean
	public Camera camera4() {
		return new Camera();
	}
	
	@Bean
	@Qualifier("intrusionDetection")
	public InfraredRaySensor windowSensor() {
		return new InfraredRaySensor("â ����");
	}
	
	@Bean
	@Qualifier("intrusionDetection")
	public InfraredRaySensor doorSensor() {
		return new InfraredRaySensor("�� ����");
	}

	@Bean
	public InfraredRaySensor lampSensor() {
		return new InfraredRaySensor("�� ����");
	}
	
	@Bean
	public AlarmDevice alarmDevice() {
		return new SmsAlarmDevice();
	}
	
	@Bean
	public Viewer viewer() {
		return new MonitorViewer();
	}
	
	@Bean
	public HomeController homeController() {
		return new HomeController();
	}
	
	@Bean
	@Qualifier("main")
	public Recorder recorder() {
		return new Recorder();
	}
	
	@Bean
	public DisplayStrategy displayStrategy() {
		return new DefaultDisplayStrategy();
	}
}
