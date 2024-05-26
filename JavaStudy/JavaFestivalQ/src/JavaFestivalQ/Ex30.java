package JavaFestivalQ;

import java.util.Arrays;
import java.util.Scanner;

public class Ex30 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("==== 알파벳 빈도수 구하기 ====");
		System.out.print("입력 >> ");
		String str = sc.nextLine();
		alpa(str);

	}

	// 반환값이 void 이므로 결과(return)을 출력하지 않음
	private static void alpa(String str) {

		char[] arr = new char[str.length()];

		for (int i = 0; i < str.length(); i++) {
			arr[i] = str.charAt(i);
		}

		// 알파벳의 문자를 카운트 할 수 있는 배열 생성
		int[] cntarr = new int[26];

		for (int i = 0; i < arr.length; i++) {
			// a보다 크고 z보다 작을 경우 해당되는 배열의 값을 1증가 시킴
			if (arr[i] >= 'a' && arr[i] <= 'z') {
				cntarr[arr[i] - 'a']++;
			}
			// A보다 크고 Z보다 작을 경우 해당되는 배열의 값을 1증가 시킴
			else if (arr[i] >= 'A' && arr[i] <= 'Z') {
				cntarr[arr[i] - 'A']++;
			}
		}

		// 배열의 값을 순회하며 출력
		for (int i = 0; i < 26; i++) {
			System.out.println((char) (i + 'a') + " : " + cntarr[i]);
		}
	}
}
