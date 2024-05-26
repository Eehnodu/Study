package 다중if문;
import java.util.Scanner;

public class Ex02학점계산프로그램 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수 입력 : ");
		int totalScore = sc.nextInt();
		
		if(totalScore >= 90) {
			System.out.println("A학점입니다!");
		}else if(totalScore >= 80 && totalScore < 90) {
			System.out.println("B학점입니다!");
		}else if(totalScore >= 70 && totalScore < 80) {
			System.out.println("C학점입니다!");
		}else {
			System.out.println("D학점입니다!");
		}
		
		
	}

}
