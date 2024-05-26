package day3;

import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("단수 입력 : ");
		int dan = sc.nextInt();
		System.out.print("어느 수까지 출력 : ");
		int num = sc.nextInt();
		
		System.out.println(dan + "단");
		for(int j = 1; j<=num; j++) {
			System.out.println(dan + "*" + j + "=" + (dan*j));
		}
	}

}
