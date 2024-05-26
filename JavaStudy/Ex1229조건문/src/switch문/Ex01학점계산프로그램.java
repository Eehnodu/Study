package switch문;
import java.util.Scanner;

public class Ex01학점계산프로그램 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("학점을 입력하세요 : ");
		int totalScore = sc.nextInt();
		
		switch(totalScore/10){
		case 10,9:
			System.out.println("A학점입니다.");
			break;
		case 8:
			System.out.println("B학점입니다.");
			break;
		case 7:
			System.out.println("C학점입니다.");
			break;
		default:
			System.out.println("D학점입니다.");
			break;
		}
	}

}
