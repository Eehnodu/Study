package 배열;

import java.util.Random;

public class Ex03홀수찾기 {

	public static void main(String[] args) {
		Random ran = new Random();
		int[] arr = new int[5];
		int j =0;
		
		System.out.print("array에 들어있는 홀수는 : ");
		
		for(int i = 0; i<arr.length; i++) {
			arr[i] = ran.nextInt(99)+1;
			if(arr[i] % 2== 1) {
				j++;
				System.out.print(arr[i] + " ");
			}
		}	
		
		System.out.print("이며,\n총 " + j +"개 입니다.");
		
	}

}
