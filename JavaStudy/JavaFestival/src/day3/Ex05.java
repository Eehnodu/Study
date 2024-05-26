package day3;

import java.util.Scanner;

public class Ex05 {

	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("정수 입력 : ");
        int num = sc.nextInt();
        int sum = 0;
        
        for (int i = 10000000; i >= 1; i/=10) {
            int digit = (num / i) % 10; 
            sum += digit;
        }
        System.out.print("합은 " + sum + "입니다.");
	}
}
  