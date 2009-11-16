package kame.spring.chap04;

public class MonitorViewer implements Viewer {

	@Override
	public void add(Camera camera) {
		System.out.println("MonitorViewer에 " + camera + " 영상 추가");
	}

}
