package 이중for문;

public class Ex01별찍기기초 {

	public static void main(String[] args) {
		for(int i = 0; i< 5; i++) {
			for(int j = 0; j<= i; j++) {
				System.out.print("*");
			}
			System.out.println("");
		}
	}

}
