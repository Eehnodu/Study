package day3;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("입력 : ");
		int num = sc.nextInt();
		int fac = 1;
		
		for(int i = 1; i<num; i++) {
			fac *= i;
		}
		System.out.print("출력 : " + fac);
	}

}
