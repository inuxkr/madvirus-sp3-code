package kame.spring.chap04;

public class SmsAlarmDevice implements AlarmDevice {

	@Override
	public void alarm() {
		System.out.println("SMS 알람 발송");
	}

}
