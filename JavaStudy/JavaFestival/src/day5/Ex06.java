package day5;

import java.util.Arrays;
import java.util.Scanner;

public class Ex06 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("==== 채점하기 ====");
		String result = sc.next();
		char[] arr = new char[6];
		
		// 입력된 문자열을 charAt()를 이용하여 하나씩 문자 배열 arr에 저장
		for(int i = 0; i< result.length(); i++) {
			arr[i] = result.charAt(i);
		}
		
		// sum과 연속된 o를 확인할 count 선언
		int sum = 0 , count = 0;
		for(int i = 0; i< arr.length; i++) {
			// 배열을 순차하며 배열의 값이 'o'일 경우 count를 하나씩 더하고 count 값을 sum에 더함
			if(arr[i] == 'o') {
				count++;
				sum += count;
			}else {
				// 'o'이 아닐 경우, count 값을 0으로 초기화함
				count = 0;
			}	
		}
		System.out.println(Arrays.toString(arr));
		System.out.println(sum);
	}

}