package JavaFestivalQ;

import java.util.Scanner;

public class Ex07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("행 개수 : ");
		int num = sc.nextInt();
		
		for(int i = num; i > 0; i--) {
			for(int j = i; j>0; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
