package JavaFestivalQ;

public class Bonus06 {

	public static void main(String[] args) {
		int base = 10;
		int n = 2;
		int result = powerN(base, n);
		System.out.println("결과 확인 : " + result);
	}

	private static int powerN(int base, int n) {
		
		int result = base;
		for(int i = 1; i<n; i++) {
			result *= base;
		}
		return result;
	}

}
