package JavaFestivalQ;

import java.util.Scanner;

public class Ex15 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("n 입력 : ");
		int n = sc.nextInt();
		int sum = 1;
		
		for(int i = 1; i <= n; i++) {
			// 1씩 증가하는 값을 더하기 때문에 출력을 먼저하고 sum을 더함
			System.out.print(sum + " ");
			sum += i;
		}
	}

}
