package 메소드;

import java.util.Scanner;

public class Ex04가까운수찾기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("정수 입력 : ");
		int num2 = sc.nextInt();
		int result = close10(num1,num2);
		System.out.println("10에 가까운 수 : " +result);
	}

	private static int close10(int num1, int num2) {
//		int result1 = (num1 < 10)? (10-num1): (num1-10);
//		int result2 = (num1 < 10)? (10-num2): (num2-10);
//		return result1<result2? num1: (result2<result2)? num2 : 0;
		
		return Math.abs(num1-10) > Math.abs(num2 - 10)? num2:
			Math.abs(num1-10) < Math.abs(num2 - 10)? num1 :0;
	}
}
