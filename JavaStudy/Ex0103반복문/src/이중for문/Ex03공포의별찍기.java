package 이중for문;

import java.util.Scanner;

public class Ex03공포의별찍기 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("행 개수 : ");
		int num = sc.nextInt();
		for(int i = num; i > 0; i--) {
			for(int j = 1; j <= num; j++) {
				System.out.print(j >= i ? "*": " ");
			}
			System.out.println();
		}

	}

}
