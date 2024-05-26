package JavaFestivalQ;

import java.util.Arrays;

public class Ex13 {

	public static void main(String[] args) {
		String score = "A,A,B,C,D,A,C,D,D,D,F";
		String[] arr = score.split(",");
		int[] cntarr = new int[5];
				
		for(int i = 0; i<arr.length; i++) {
			if(arr[i].equals("A")) {
				cntarr[0]++;
			}else if(arr[i].equals("B")) {
				cntarr[1]++;
			}else if(arr[i].equals("C")) {
				cntarr[2]++;
			}else if(arr[i].equals("D")) {
				cntarr[3]++;
			}else {
				cntarr[4]++;
			}
		}
		System.out.println("A : " + cntarr[0] + "명");
		System.out.println("B : " + cntarr[1] + "명");
		System.out.println("C : " + cntarr[2] + "명");
		System.out.println("D : " + cntarr[3] + "명");
		System.out.println("F : " + cntarr[4] + "명");
	}
}
