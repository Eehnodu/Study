package 이차원배열;

import java.util.Arrays;

public class Ex01이차원배열생성 {

	public static void main(String[] args) {
			
		// 이차원 배열
		// : 배열 안에 또 다른 배열이 있는 형태
		// : 참조가 2번 일어나는 형태(참조의 참조)
		
		// 1. 이차원 배열 선언방법
		// 자료형[][] 변수명 = new 자료형[행][열];
		int[][] arr = new int[3][3];
		int num = 1;
		for(int i = 0; i<arr.length; i++){
			for(int j = 0; j<arr.length; j++) {
				arr[i][j] = num++;
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
	}
}
