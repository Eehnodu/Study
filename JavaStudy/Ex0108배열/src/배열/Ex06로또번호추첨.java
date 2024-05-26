package 배열;

import java.util.Arrays;
import java.util.Random;

public class Ex06로또번호추첨 {

	public static void main(String[] args) {
		Random ran = new Random();
		int[] arr = new int[50];
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = ran.nextInt(99)+1;
			for(int j = 0; j<i; j++) {
				if(arr[j] == arr[i]) {
					i--;
					break;
				}
			}
		}
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
