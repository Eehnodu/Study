package JavaFestivalQ;

public class Bonus02 {

	public static void main(String[] args) {
		System.out.println(getMiddle("power"));
		System.out.println(getMiddle("test"));
	}

	private static String getMiddle(String str) {
		
		// substring --> 문자열 자르기 함수
		// substring(start index, end index)
		if(str.length()%2==0) {
			return str.substring(str.length()/2 - 1, str.length()/2+1);
		}else {
			return str.substring(str.length()/2, str.length()/2 + 1);
		}
		

	}
}
