package day1;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("일한시간을 입력하세요 : ");
		int time = sc.nextInt();
		int few = 5000;
		int total = 0;
		int time2 = 0;
		if (time > 8 ) {
			time2 = time - 8;
			total = few * 8 + (int)(time2 * few * 1.5);
			System.out.println("총 임금은 " + total + "원 입니다.");
		}else {
			System.out.println("총 임금은 " + few*time +"원 입니다.");
		}
	}

}
