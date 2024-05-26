package 닌텐도게임;

// 2. 추상 클래스
// - 추상 메소드를 하나라도 가조기 있으면 반드시 추상 클래스가 되어야 한다.
// - 추상 클래스도 일반 메소드 가지고 있을 수 있다.
// - abstract 키워드를 사용해서 선언한다.
// - 일반 메소드만 가지고 있어도 추상클래스가 될 수 있다.
public abstract class GameChip {
	public abstract void gameStart();
	// 1. 추상 메소드
	// - {}가 없는 중간 메소드
	//   선언(틀 : 메소드명, 매개변수, 리턴타입)은 되어있으나
	//   로직이 구현되지 않은 메소드
	// - abstract 키워드를 사용해 선언한다.
	
	public void gameEnd() {
		
	}
}
