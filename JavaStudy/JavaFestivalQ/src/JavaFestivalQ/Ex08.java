package JavaFestivalQ;

import java.util.Scanner;

public class Ex08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자 입력 : ");
		int num = sc.nextInt();
		
		if(num > 0) {
			num = num % 10 >= 5? num/10*10 + 10: num/10*10;
		}
		
		System.out.println("반올림 수 : " + num);
	}

}
