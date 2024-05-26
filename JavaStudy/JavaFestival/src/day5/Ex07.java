package day5;

import java.util.Arrays;
import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[5];
		
		// 입력받은 값을 배열에 저장
		for(int i = 0; i<arr.length; i++) {
			System.out.print((i+1) + "번째 수 입력 : ");
			int num = sc.nextInt();
			arr[i] = num;
		}
		
		System.out.println("정렬 후");
		for(int i = 0; i<arr.length-1; i++) {
			// 첫번째 배열부터 마지막 배열까지 하나씩 비교하며 순회
			for(int j = 0; j<arr.length-1; j++) {
				// 임시로 값을 저장하기 위한 tmp을 선언 후, 저장한 후에 조건이 맞다면 앞과 뒤의 배열을 교체
				int tmp;
				if(arr[j] > arr[j+1]) {
					tmp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}

}
