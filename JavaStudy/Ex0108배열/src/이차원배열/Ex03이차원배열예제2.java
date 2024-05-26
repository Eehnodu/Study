package 이차원배열;

import java.util.Scanner;

public class Ex03이차원배열예제2 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int[][] arr = new int[5][5];
		int num = 21;
		
		for(int i = 0; i<arr.length; i++) {
			// i가 0 혹은 짝수일 경우 배열이 순차적으로 증가하며 값을 넣음
			if(i % 2 == 0) {
				for(int j = 0; j<arr.length; j++) {
					arr[i][j] = num++;
				}
			}
			// i가 홀수일 경우 배열이 감소하며 값을 넣음
			else {
				for(int j = 4; j>=0; j--) {
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
