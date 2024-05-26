package day5;

import java.util.Scanner;

public class Ex02 {

	public static void main(String[] args) {	
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[10];
		
		for(int i=0; i<10; i++) {
			System.out.print((i+1) + "번 째 정수 입력 >> ");
			int num = sc.nextInt();
			arr[i] = num;
		}
		
		// 3으로 나누었을 경우, 나머지가 0일 때의 값들을 순회하며 출력
		System.out.print("3의 배수 :");
		for(int i=0; i<arr.length; i++) {
			if(arr[i]%3==0) {
				System.out.print(" " + arr[i]);				
			}
		}
	}

}
