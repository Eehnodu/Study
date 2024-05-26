package day6;

import java.util.Scanner;

public class Ex03 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 정할 정수 N 입력 : ");
		int n = sc.nextInt();
		
		// 원본
		System.out.println("원본");
		int[][] orig = new int[n][n];
		int num = 1;
		// 원본 배열에 값 넣기
		for(int i = 0; i<orig.length; i++) {
			for(int j = 0; j<orig.length; j++) {
				orig[i][j] = num++;
			}
		}
		// 원본 배열 출력
		for(int i = 0; i<orig.length; i++) {
			for(int j = 0; j<orig.length; j++) {
				System.out.printf("%4d", orig[i][j]);
			}
			System.out.println();
		}
		
		System.out.println("\n90도 회전");
		int[][] trans = new int[n][n];
		num = 1;
		// 90도 회전 배열 값 넣기
		for(int i = 0; i<trans.length; i++) {
			for(int j = n-1; j>=0; j--) {
				// trans[n-1][0]부터 n-1이 감소하면서 값을 넣고
				// for문이 끝나면 i가 1증가하며 다시 n-1이 감소하면서 채움
				// trans[n-1][0] -> trans[n-1-1][0] -> trans[n-1-1-1][0] ....
				trans[j][i] = num++;
			}
		}
		// 90도 회전 배열 출력
		for(int i = 0; i<trans.length; i++) {
			for(int j = 0; j<trans.length; j++) {
				System.out.printf("%4d", trans[i][j]);
			}
			System.out.println();
		}
	}
}
