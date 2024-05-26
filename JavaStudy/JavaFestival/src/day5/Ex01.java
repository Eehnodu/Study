package day5;

import java.util.Arrays;
import java.util.Random;

public class Ex01 {

	public static void main(String[] args) {
		Random ran = new Random();
		int[] arr = new int[7];
		
		for(int i =0; i<arr.length; i++) {
			arr[i] = ran.nextInt(99)+1;
		}
		System.out.print("배열에 있는 모든 값 :");
		int max = arr[0], min = arr[0];
		for(int i =0; i<arr.length; i++) {
			System.out.print(" " + arr[i]);
			// 삼항연산자를 이용해 MAX 값과 MIN 값 비교
			max = max > arr[i]? max: arr[i];
			min = min < arr[i]? min: arr[i];
		}
		System.out.println("\n가장 큰 값 : " + max);
		System.out.println("가장 작은 값 : " + min);
	}

}
