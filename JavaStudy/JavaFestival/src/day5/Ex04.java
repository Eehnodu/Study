package day5;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		// 값을 입력하여 배열에 저장
		for(int i = 0; i<arr.length; i++) {
			System.out.print(i + "번째 별의 수 : ");
			int num = sc.nextInt();
			arr[i] = num;
		}
		
		// 배열의 값들을 순회하며 가져와서 배열에 저장된 값에 따라 *의 개수 출력
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " : ");
			for(int j = 0; j < arr[i]; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
