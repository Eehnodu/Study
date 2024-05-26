package 산술연산자;

import java.util.Scanner;

public class Ex03산술연사자예제2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		// 변수 num 값을 입력받아 백의 자리 이하를 버리는 코드를 작성
				System.out.print("정수입력: ");
				int a = sc.nextInt();
				System.out.println("결과 값: "+a/100+0+0);
				System.out.println("결과 값: "+(a-a%100));
		
	}

}
