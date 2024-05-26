package 배열;

import java.util.Random;

public class Ex04가장큰수찾기 {

	public static void main(String[] args) {
		Random ran = new Random();
		int[] arr = new int[5];
		
		System.out.print("배열 안에 들어 있는 값 : ");
		for(int i = 0; i<arr.length; i++) {
			arr[i] = ran.nextInt(9)+1;
			System.out.print(arr[i] + " ");

		}
		
		int max = arr[0];
		for(int i = 0; i<arr.length; i++) {
			max = max >= arr[i]? max: arr[i];
		}
		
		System.out.print("\n가장 큰 값은 " + max + "입니다.");
	}	
}

