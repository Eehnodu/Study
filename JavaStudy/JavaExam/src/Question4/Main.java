package Question4;

public class Main {

	public static void main(String[] args) {
		MobilePhone mo = new MobilePhone();
		CameraPhone ca = new CameraPhone();
		SmartPhone sm = new SmartPhone();
		
		mo.call();
		mo.message();
		System.out.println();
		ca.call();
		ca.message();
		ca.picture();
		ca.music();
		System.out.println();
		sm.call();
		sm.message();
		sm.kakaoTalk();
		sm.wifi();
		
	}

}
