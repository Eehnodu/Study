package 다중if문;
import java.util.Iterator;
import java.util.Scanner;

public class Ex01다중if문 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		if(num==0) {
			System.out.println("0 입니다.");
		}else if(num % 2 ==1) {
			System.out.println("홀수입니다.");
		}else {
			System.out.println("짝수입니다.");
		}
	}
}
