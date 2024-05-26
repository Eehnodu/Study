package day4;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {
		
//		Scanner sc = new Scanner(System.in);
//		System.out.print("행 개수 : ");
//		int num = sc.nextInt();
//		for(int i = num; i > 0; i--) {
//			for(int j = 1; j < i; j++) {
//				System.out.print(" ");
//			}
//			for(int k = 0; k <= num-i; k++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("행 개수 : ");
		int num = sc.nextInt();
		for(int i = num; i > 0; i--) {
			for(int j = num; j > 0; j--) {
				System.out.print(j <= num-i+1 ? "*": " ");
			}
			System.out.println();
		}
	}

}
