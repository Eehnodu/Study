package While문;

import java.util.Scanner;

public class Ex03Whilte문예제2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		while(true) {
			System.out.print("정수 입력 : ");
			int num = sc.nextInt();
			total += num;
			System.out.println("누적결과 : " + total);
			if(num == -1) {
				System.out.println("종료되었습니다.");
				break;
			}
		}
	}
}
