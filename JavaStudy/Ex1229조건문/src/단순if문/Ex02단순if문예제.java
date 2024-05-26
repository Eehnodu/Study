package 단순if문;
import java.util.Scanner;

public class Ex02단순if문예제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		
		if(num % 3 == 0 && num % 5 == 0) {
			System.out.println("3과 5의 배수 입니다.");
		}
		else {
			System.out.println("3과 5의 배수가 아닙니다.");
		}
		
//		 System.out.println(num % 3 == 0 && num % 5 == 0 ? "3과 5의 배수 입니다." : "3과 5의 배수가 아닙니다.");
//		
//		if(num % 3 == 0) {
//			if(num % 5 == 0) {
//				System.out.print("3과 5의 배수 입니다.");
//			}
//		}
//		else {
//			System.out.print("3과 5의 배수가 아닙니다.");
//		}
	}

}
