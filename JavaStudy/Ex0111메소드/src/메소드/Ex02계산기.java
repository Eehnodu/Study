package 메소드;

import java.util.Scanner;

public class Ex02계산기 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 1 입력 : ");
		int num1 = sc.nextInt();
		System.out.print("정수 2 입력 : ");
		int num2 = sc.nextInt();
		System.out.print("연산자 op 입력 : ");
		String op = sc.next();
		System.out.println(cal(num1,num2, op));

	}
	
	public static int cal(int num1 , int num2, String op) {
		// switch 문
		switch(op) {
		case "+": 
			return num1 + num2; 
		case "-":
			return num1 > num2? num1-num2: num2-num1; 
		case "*":
			return num1*num2; 
		case "/":
			return num1/num2; 
		}
		return 0;
		
	}
}
