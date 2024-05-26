package ifelse문;
import java.util.Scanner;

public class Ex02ifelse문예제 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("====에버랜드에 오신 걸 환영합니다!====");
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.print("인원수를 입력하세요 : ");
		int mem = sc.nextInt();
		
		if(age<20) {
			System.out.print("총" + (mem * 5000/2)+ "원입니다.");
		}else {
			System.out.print("총" + (mem * 5000)+ "원입니다.");
		}
	}
}
