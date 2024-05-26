package 이차원배열;

import java.util.Arrays;

public class Ex02이차원배열예제1 {

	public static void main(String[] args) {
		
		int[][] arr = new int[5][5];
		int num = 16;
		for(int i = 0; i<arr.length; i++) {
			for(int j = 0; j<arr.length; j++) {
				arr[i][j] = num +=5;
				System.out.print(arr[i][j] + "\t");
			}
			num = num-24;
			System.out.println();
		}
	}

}
