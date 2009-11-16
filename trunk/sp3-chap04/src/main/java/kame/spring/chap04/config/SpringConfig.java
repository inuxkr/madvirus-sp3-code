package kame.spring.chap04.config;

import java.util.ArrayList;
import java.util.List;

import kame.spring.chap04.homecontrol.AlarmDevice;
import kame.spring.chap04.homecontrol.Camera;
import kame.spring.chap04.homecontrol.HomeController;
import kame.spring.chap04.homecontrol.InfraredRaySensor;
import kame.spring.chap04.homecontrol.MonitorViewer;
import kame.spring.chap04.homecontrol.SmsAlarmDevice;
import kame.spring.chap04.homecontrol.Viewer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {
	
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
	public InfraredRaySensor windowSensor() {
		return new InfraredRaySensor("창 센서");
	}
	
	@Bean
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
	
	@Bean(initMethod="init")
	public HomeController homeController() {
		HomeController homeController = new HomeController();
		
		List<InfraredRaySensor> sensors = new ArrayList<InfraredRaySensor>();
		sensors.add(windowSensor());
		sensors.add(doorSensor());
		homeController.setSensors(sensors);
		
		homeController.prepare(alarmDevice(), viewer());
		
		homeController.setCamera1(camera1());
		homeController.setCamera2(camera2());
		homeController.setCamera3(camera3());
		homeController.setCamera4(camera4());
		
		return homeController;
	}
}
