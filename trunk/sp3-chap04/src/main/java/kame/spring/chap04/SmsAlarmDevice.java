package kame.spring.chap04;

public class SmsAlarmDevice implements AlarmDevice {

	@Override
	public void alarm(String name) {
		System.out.println(name + "���� ħ�� Ž��");
	}

}
