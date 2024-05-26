package JavaFestivalQ;

public class Ex09 {

	public static void main(String[] args) {
		
		// 'A'의 10진수는 65 // 'Z'의 10진수는 90 
		for(int i = 65; i<=90; i++) {
			//char는 문자 타입 --> 숫자를 문자로 변환하기위해 (char)를 이용하여 형 변환
			char ch = (char)i;
			System.out.print(ch + " ");
		}
	}

}
