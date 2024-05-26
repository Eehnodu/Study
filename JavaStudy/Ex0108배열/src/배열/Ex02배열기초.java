package 배열;

public class Ex02배열기초 {

	public static void main(String[] args) {
		
		int[] numbers = new int[5];
		
		// 배열의 길이
		// 변수명.length;
		int length = numbers.length;
		System.out.println("배열의 길이 : " + length);
		
		// 배열의 각 칸을 5의 배수로 초기화
		for(int i = 0; i <numbers.length; i++) {
			numbers[i] = 5*(i+1);
		}
		for(int i =0; i< numbers.length; i++) {
		System.out.print(numbers[i] +  " ");
		}
		
		System.out.println();
		
		// 배열을 생성함과 동시에 데이터를 집어넣는 방법
		String[] names = {"asd", "sdf", "dfg", "fgh"};
		System.out.println(names[1]);

	}
}
