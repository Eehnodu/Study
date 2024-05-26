package 삼항연산자;
import java.util.Scanner;

public class Ex02삼항연산자예제 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in); //Scanner 선언
		System.out.print("정수를 입력하세요 : "); // 입력받를 정수 문구 출력
		int num1 = sc.nextInt(); // 입력받은 정수 선언
	
		// 삼항연산자 String으로 선언
		String result = num1 % 2 == 0 ? num1 + "는(은) 짝수입니다." : num1 + "는(은) 홀수입니다." ; 
		System.out.print(result); // 결과값 출력
	}
}
