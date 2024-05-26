package JavaFestivalQ;

import java.util.Random;

public class Ex18 {

	public static void main(String[] args) {
		Random ran = new Random();
		int[] arr = new int[6];
		
		// 중복 제거
		for(int i = 0; i<arr.length; i++) {
			arr[i] = ran.nextInt(99)+1;
			for(int j = 0; j<i; j++) {
				if(arr[j] == arr[i]) {
					i--;
					break;
				}
			}
		}
		for(int i = 0; i<arr.length; i++) {
			System.out.println("행운의 숫자 : " + arr[i]);
		}
	}

}
