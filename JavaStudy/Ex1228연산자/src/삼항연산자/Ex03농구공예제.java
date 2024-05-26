package 삼항연산자;
import java.util.Scanner;

public class Ex03농구공예제 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("농구공의 개수를 입력하세요 : ");
		int num = sc.nextInt();
		
        System.out.println("필요한 상자의 수 : " + ((num / 5) + (num % 5 == 0 ? 0 : 1)));
		
	}

}
