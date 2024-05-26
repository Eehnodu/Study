package day6;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크기를 정할 정수 N 입력 : ");
		int n = sc.nextInt();
		
		// 배열 크기 선언 및 증가할 값 num 초기화
		int[][] arr = new int[n][n];
		int num = 1;
		
		for(int i = 0; i<arr.length; i++) {
			// i가 0 혹은 짝수일 경우 배열이 순차적으로 증가하며 값을 넣음
			if(i % 2 == 0) {
				for(int j = 0; j<arr.length; j++) {
					arr[i][j] = num++;
				}
			}
			// i가 홀수일 경우 배열이 감소하며 값을 넣음
			else {
				for(int j = n-1; j>=0; j--) {
					arr[i][j] = num++;
				}
			}
		}
		// arr배열 출력
		for(int i = 0 ; i<arr.length; i++) {
			for(int j = 0; j<arr.length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
		}
	}
}
