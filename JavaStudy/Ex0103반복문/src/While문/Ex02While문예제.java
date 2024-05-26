package While문;

import java.util.Scanner;

public class Ex02While문예제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.print("정수 입력 : ");
			int num = sc.nextInt();
			if(num > 10) {
				System.out.println("종료되었습니다.");
				break;
			}
		}
	}

}
