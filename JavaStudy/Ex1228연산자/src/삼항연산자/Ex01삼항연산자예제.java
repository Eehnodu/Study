package 삼항연산자;

public class Ex01삼항연산자예제 {

	public static void main(String[] args) {
		// 삼항연산자
		// 조건문 ? 실행문 1 : 실행문2
		// ---> 조건문이 참이라면 실행문1을 실행
		// ---> 조건문이 거짓이라면 실행문2를 실행
		
		int num1 = 4;
		int num2 = 7;
		String result = num1 < num2 ? "num2가 더 크다" : "num1가 더 크다" ;
		
		System.out.println(result);
	}

}
