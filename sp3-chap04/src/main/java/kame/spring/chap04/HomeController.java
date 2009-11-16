package kame.spring.chap04;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class HomeController {

	private AlarmDevice alarmDevice;
	private Viewer viewer;

	@Resource(name = "camera1")
	private Camera camera1;

	@Resource(name = "camera2")
	private Camera camera2;

	@Resource(name = "camera3")
	private Camera camera3;

	@Resource(name = "camera4")
	private Camera camera4;

	private List<InfraredRaySensor> sensors;

	@Autowired
	public void prepare(AlarmDevice alarmDevice, Viewer viewer) {
		this.alarmDevice = alarmDevice;
		this.viewer = viewer;
	}

	@Autowired
	@Qualifier("intrusionDetection")
	public void setSensors(List<InfraredRaySensor> sensors) {
		this.sensors = sensors;
	}

	public void init() {
		viewer.add(camera1);
		viewer.add(camera2);
		viewer.add(camera3);
		viewer.add(camera4);
	}

	public void start() {

	}

	public void stop() {

	}

	public void checkSensorAndAlarm() {
		for (InfraredRaySensor sensor : sensors) {
			if (sensor.isObjectFounded()) {
				alarmDevice.alarm(sensor.getName());
			}
		}
	}
}
