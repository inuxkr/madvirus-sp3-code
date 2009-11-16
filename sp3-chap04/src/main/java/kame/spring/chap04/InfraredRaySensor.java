package kame.spring.chap04;

public class InfraredRaySensor {

	private String name;
	private boolean objectFounded;

	public InfraredRaySensor(String name) {
		this.name = name;
	}

	public boolean isObjectFounded() {
		return objectFounded;
	}

	public String getName() {
		return name;
	}

	public void foundObject() {
		objectFounded = true;
	}

}
