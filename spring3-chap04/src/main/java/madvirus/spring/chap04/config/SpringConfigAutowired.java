package madvirus.spring.chap04.config;

import madvirus.spring.chap04.homecontrol.AlarmDevice;
import madvirus.spring.chap04.homecontrol.Camera;
import madvirus.spring.chap04.homecontrol.DefaultDisplayStrategy;
import madvirus.spring.chap04.homecontrol.DisplayStrategy;
import madvirus.spring.chap04.homecontrol.HomeController;
import madvirus.spring.chap04.homecontrol.InfraredRaySensor;
import madvirus.spring.chap04.homecontrol.MonitorViewer;
import madvirus.spring.chap04.homecontrol.Recorder;
import madvirus.spring.chap04.homecontrol.SmsAlarmDevice;
import madvirus.spring.chap04.homecontrol.Viewer;

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
		return new InfraredRaySensor("창 센서");
	}
	
	@Bean
	@Qualifier("intrusionDetection")
	public InfraredRaySensor doorSensor() {
		return new InfraredRaySensor("문 센서");
	}

	@Bean
	public InfraredRaySensor lampSensor() {
		return new InfraredRaySensor("등 센서");
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
