package day6;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("배열의 크키를 정할 정수 N 입력 : ");
		int n = sc.nextInt();
		
		// 배열의 크기 선언 및 증가할 값 num 초기화
		int[][] arr = new int[n][n];
		int num = 1;
		
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length; j++) {
				// 가로로 num값을 넣고 배열의 크기만큼 증가
				arr[i][j] = num;
				num += n;
				System.out.print(arr[i][j] + "\t");
			}
			// num을 배열의 제곱만큼 빼고 1을 더함
			num = num-(n*n)+1;
			System.out.println();
		}
	}

}
