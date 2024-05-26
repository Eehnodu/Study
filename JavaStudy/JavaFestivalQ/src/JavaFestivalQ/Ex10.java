package JavaFestivalQ;

import java.util.Arrays;
import java.util.Random;

public class Ex10 {

	public static void main(String[] args) {
		Random ran = new Random();
		int[] arr = new int[8];
		
		// 1~99까지의 랜덤한 수를 배열에 저장
		for(int i =0; i<arr.length; i++) {
			arr[i] = ran.nextInt(99)+1;
		}
		System.out.print("배열에 있는 모든 값 :");
		
		// 수 비교를 위해 max와 min의 초기값을 arr[0]으로 지정
		int max = arr[0], min = arr[0];
		for(int i =0; i<arr.length; i++) {
			System.out.print(" " + arr[i]);
			// 삼항연산자를 이용해 MAX 값과 MIN 값 비교
			max = max > arr[i]? max: arr[i];
			min = min < arr[i]? min: arr[i];
		}
		System.out.println("\n가장 큰 값 : " + max);
		System.out.println("가장 작은 값 : " + min);
		
		// sort(정렬기능)을 이용하여 구하는 법
//		Arrays.sort(arr);
//		System.out.println("\n가장 큰 값 : " + arr[arr.length-1]);
//		System.out.println("가장 작은 값 : " + arr[0]);
	}

}
