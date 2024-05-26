package JavaFestivalQ;

import java.util.Scanner;

public class Ex04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("총금액 입력 : ");
		int money = sc.nextInt();
		System.out.println("");
		
		// if문
//		if(money > 0) {
//			System.out.println("잔돈 : " + money);
//			System.out.println("10000원 : " + money/10000 + "개");
//			System.out.println("5000원 : " + money%10000/5000 + "개");
//			System.out.println("1000원 : " + money%5000/1000 + "개");
//			System.out.println("500원 : " + money%1000/500 + "개");
//			System.out.println("100원 : " + money%500/100 + "개");
//		}
		
		// for문
		int[] currency = {10000, 5000, 1000, 500, 100};
		for(int i = 0; i<currency.length; i++) {
			System.out.println(currency[i] + "원 : " + money/currency[i] +"개" );
			money %= currency[i];
		}
		
	}

}
