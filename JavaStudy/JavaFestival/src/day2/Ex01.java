package day2;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("현재 몸무게 : ");
		int now = sc.nextInt();
		System.out.print("목표 몸무게 : ");
		int future = sc.nextInt();
		int num = 1;
		while(true) {
			System.out.print(num + "주차 감량 몸무게 : ");
			num++;
			int kg = sc.nextInt();
			now = now - kg;
			if(now <= future) {
				System.out.println(now + "kg 달성!! 축하합니다!!");
				break;
			}
		}
	}

}
