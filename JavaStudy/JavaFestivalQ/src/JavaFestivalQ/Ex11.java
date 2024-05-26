package JavaFestivalQ;

public class Ex11 {

	public static void main(String[] args) {
		int num1 = 10;
		int num2 = 2;
		boolean result = isDivide(num1, num2);
		System.out.println("결과 확인 : " + result);
	}
	
	private static boolean isDivide(int num1, int num2) {
		return num1%num2 == 0? true: false;
	}

}
