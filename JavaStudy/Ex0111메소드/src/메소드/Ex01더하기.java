package 메소드;

public class Ex01더하기 {

	public static void main(String[] args) {
		System.out.println(addDouble(4.2, 3.14));
		System.out.println(subNum(2,2));
		printHello();
	}
	
	// 1.메소드 생성(main 영역 벗어나서 작성하기)
	// 리턴타입 : double / 매개변수 : 2개 double / 메소드 명 : addDouble
	public static double addDouble(double num1, double num2) {
		// 메소드는 return을 만나면 데이터를 반환하고 끝난다.
		// 즉, return 키워드 왼쪽에 코드를 작성할 것!
		return num1 + num2;
	}
	
	public static int subNum (int num1, int num2) {
		return num1 > num2? num1 - num2: num2 -num1; 
	}
	
	public static void printHello () {
		for(int i = 0; i<5; i++) {
			System.out.println("Hello world!");
		}
	}
}
