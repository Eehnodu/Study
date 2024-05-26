package For문;

import java.util.Scanner;

public class Ex04구구단 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("단 입력 : ");
		int dan = sc.nextInt();
		System.out.print("어느 수까지 출력 : ");
		int num = sc.nextInt();
		for(int j = 1; j<=num; j++) {
			System.out.println(dan + "*" + j + "=" + (dan*j));
		}
	}
}


