package JavaFestivalQ;

import java.util.Arrays;
import java.util.Scanner;

public class Ex25 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("첫자리 0을 제외한 숫자를 입력해주세요 >> ");
		String num = sc.next();
		
		int sum = 0;
		String[] arr = num.split("");
		
		for(int i = 0; i<arr.length; i++) {
			// if-else 문
//			if(arr[i].equals("0")) {
//				sum +=6;
//			}else if(arr[i].equals("1")) {
//				sum +=2;
//			}else if(arr[i].equals("2")) {
//				sum +=5;
//			}else if(arr[i].equals("3")) {
//				sum +=5;
//			}else if(arr[i].equals("4")) {
//				sum +=4;
//			}else if(arr[i].equals("5")) {
//				sum +=5;
//			}else if(arr[i].equals("6")) {
//				sum +=6;
//			}else if(arr[i].equals("7")) {
//				sum +=3;
//			}else if(arr[i].equals("8")) {
//				sum +=7;
//			}else if(arr[i].equals("9")) {
//				sum +=6;
//			}
			
			// switch-case 문
			switch(arr[i]) {
			case "8":
				sum += 7;
				break;
			case "0", "6", "9":
				sum += 6;
				break;
			case "2", "3", "5":
				sum += 5;
				break;
			case "4":
				sum += 4;
				break;
			case "7":
				sum += 3;
				break;
			case "1" :
				sum += 2;
				break;
			}
			
		}
		System.out.print("대시('-')칑 총 합 >> " + sum);
	}
	
}
