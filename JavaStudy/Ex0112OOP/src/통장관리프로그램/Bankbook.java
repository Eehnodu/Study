package 통장관리프로그램;

public class Bankbook {
	// 통장관리 프로그래믈 만든다고 가정
	// 통장 설계도면 ---> 통장을 관리할  수 있는 우리만의 자료형 만들기
	
	// 1. Field(Data, 속성)
	private int money;
	// 정보은닉을 지켜주어야한다. (사용자 임의로 변경하는 것을 막는다.)
	
	
	
	
	// 2. Method(행위, 로직, 기능)
	public void deposit(int money) {
		this.money += money;
		// this : 현재 클래스 자체를 의마하는 키워드
		
	}
	public void withdraw(int money) {
		this.money -= money;
	}
	public int showMoney() {
		return money;
	}
	
	
	// 3. 
}
