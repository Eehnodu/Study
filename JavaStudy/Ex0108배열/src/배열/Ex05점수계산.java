package 배열;

import java.util.Arrays;
import java.util.Scanner;

public class Ex05점수계산 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int[] arr = new int[5];
		
		for(int i = 0; i<5; i++) {
			System.out.print((i+1) + "번째 입력 >> ");
			int num = sc.nextInt();
			arr[i] = num;
		}
		System.out.print("입력된 점수 : " + Arrays.toString(arr));
		
		int max = arr[0], min = arr[0], sum =0;
		for(int i = 0; i<arr.length; i++) {
			max = max >= arr[i] ? max: arr[i];
			min = min <= arr[i] ? min :arr[i];
			sum += arr[i];
		}
		System.out.println();
		System.out.println("최고 점수 : " + max);
		System.out.println("최저 점수 : " + min);
		System.out.println("총합 : " + sum);
		System.out.println("평균 : " + (float)sum/arr.length);
		
	}

}
