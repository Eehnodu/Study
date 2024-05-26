package day3;

public class Ex01 {

	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i<=100 ; i++) {
			//삼항연사자를 이용해 홀수일 경우 1, 짝수일 경우 -1을 곱해서 계산
			int result = (i % 2 == 1)? 1: -1;
			sum += i * result;
			System.out.print((i * result) + " ");
		}
		System.out.print("\n결과 : " + sum);
	}

}
