package kame.spring.chap04.homecontrol;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("viewer")
public class MonitorViewer implements Viewer {

	@Autowired
	private DisplayStrategy displayStrategy;

	public void setDisplayStrategy(DisplayStrategy displayStrategy) {
		this.displayStrategy = displayStrategy;
	}

	@Override
	public void draw() {
		System.out.println("DisplayType "
				+ displayStrategy.getDisplayType().name() + "로 카메라 이미지 출력");
	}

	@Override
	public void add(Camera camera) {
		System.out.println("MonitorViewer에 " + camera + " 영상 추가");
	}

}
