package doWhile문;

import java.util.Scanner;
import java.util.Random;

public class Ex03플러스게임 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		System.out.println("===Plus Game===");
		while(true) {
			int num1 = ran.nextInt(9)+1;
			int num2 = ran.nextInt(9)+1;
			System.out.print(num1 + " + " +num2 + " = ");
			int sol = sc.nextInt();
			int pro = num1 + num2;
			if(pro == sol) {
				System.out.println("Success!!");
			}else {
				System.out.println("Fail..");
				System.out.print("계속하시겠습니까 >> ");
				String ret = sc.next();
				if(ret.equals("N")) {
					System.out.println("종료되었습니다.");
					break;
				}else if(ret.equals("Y")) {
					continue;
				}else {
					System.out.print("다시 입력해 주세요 >> ");
					ret = sc.next();
					if(ret.equals("N")) {
						System.out.println("종료되었습니다.");
						break;
					}else if(ret.equals("Y")) {
						continue;
					}
				}
			}
		}
		
	}
}


