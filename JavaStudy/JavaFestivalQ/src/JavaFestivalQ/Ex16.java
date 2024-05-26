package JavaFestivalQ;

import java.util.Scanner;

public class Ex16 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int num = sc.nextInt();
        int sum = 0;
        
        for (int i = 10000000; i >= 1; i/=10) {
        	// 몫을 먼저 구한후 몫의 나머지(일의 자리)만 계속 더함
            int digit = (num / i) % 10;
            sum += digit;
        }
        System.out.print("합은 " + sum + "입니다.");
	}
}
  