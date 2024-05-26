package 단순if문;
import java.util.Scanner;

public class Ex01단순if문 {

	public static void main(String[] args) {
		// 1. 입력도구 꺼내오기
		Scanner sc = new Scanner(System.in);
		// 2. 나이를 입력하세요 . 출력
		System.out.print("나이를 입력하세요 >> ");
		// 3. 나이 입력 받기
		int age = sc.nextInt();
		// 4. age가 20보다 크거나 같다면 성인입니다. 출력
		if(age>=20) {
			System.out.print("성인입니다.");
		}
		else {
			System.out.println("미성년자입니다.");
		}
	}
}
