package 메소드;

import java.util.Scanner;

public class Ex05완전수구하기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("num1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("num2 입력 : ");
		int num2 = sc.nextInt();
		boolean divisor = isDivisor(num1,num2);
		System.out.println(divisor);
		
		System.out.print("약수의 합 : ");
		System.out.println(getSum(44));
		System.out.print("입력 값 >> ");
		int s = sc.nextInt();
		System.out.println("완전 수 인가 ? " + isPerfect(s));
	}

	private static boolean isDivisor(int num1, int num2) {
		
		return num1%num2 == 0? true: false;
	}
	
	private static int getSum(int j) {
		int sum = 0;
		for(int i = 1; i<j; i++) {
			if(isDivisor(j,i)) {
				sum += i;
			}
		}
		return sum;
	}

	private static boolean isPerfect(int i) {
		return getSum(i) == i? true: false;
	}

}
