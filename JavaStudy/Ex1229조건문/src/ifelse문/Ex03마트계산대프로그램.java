package ifelse문;
import java.util.Scanner;

public class Ex03마트계산대프로그램 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("상품의 개수를 입력하세요 : ");
		int num = sc.nextInt();
		int price ;
		
		if(num>10) {
			price = (int)(num * 10000 * 0.9);
			System.out.print("가격은 " + price +"원입니다.");
		}else {
			price = (int)(num * 10000);
			System.out.print("가격은 " + price + "원입니다.");
		}
	}

}
