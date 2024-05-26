package While문;

import java.util.Scanner;

public class Ex04While문예제3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int even = 0, odd = 0;
		while(true) {
			System.out.print("숫자 입력 : ");
			int num = sc.nextInt();
			if(num == -1) {
				System.out.println("종료되었습니다.");
				break;
			}
			if(num % 2 == 0) {
				even ++;
			}else {
				odd ++;
			}
			System.out.print("짝수 개수 : " + even + "\n" + "홀수 개수 : " + odd + "\n");
			}
		}
}
