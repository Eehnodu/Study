package JavaFestivalQ;

import java.util.Scanner;

public class Ex01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("현재 몸무게 : ");
		int now = sc.nextInt();
		System.out.print("목표 몸무게 : ");
		int future = sc.nextInt();

		// 방법1 (while문)
//		int num = 1;
//		while(true) {
//			System.out.print(num + "주차 감량 몸무게 : ");
//			num++;
//			int kg = sc.nextInt();
//			now -= kg;
//			if(now <= future) {
//				System.out.println(now + "kg 달성!! 축하합니다!!");
//				break;
//			}
//		}
		
		
		// 방법2 (for문)
		for(int i = 1; now>future; i++) {
			System.out.print(i + "주차 감량 몸무게 : ");
			int kg = sc.nextInt();
			now -= kg;
			if(now<=future) {
				System.out.println(now + "kg 달성!! 축하합니다.");
			}
		}
		
	}

}
