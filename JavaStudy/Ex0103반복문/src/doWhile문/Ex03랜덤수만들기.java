package doWhile문;

import java.util.Scanner;
import java.util.Random;


public class Ex03랜덤수만들기 {

	public static void main(String[] args) {
		Random ran = new Random();
		int ranNum = ran.nextInt(9)+1;
		System.out.println(ranNum);
		
	}
}
