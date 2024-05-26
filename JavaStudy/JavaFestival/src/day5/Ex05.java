package day5;

import java.util.Arrays;

public class Ex05 {

	public static void main(String[] args) {
		int[] point = {92,32,52,9,81,2,68};
		int[] result = new int[2];
		
		int min = point[0] - point[1];
		
		for(int i = 0; i<point.length; i++) {
			for(int j = i+1; j<point.length;j++) {
				
				// 차이를 비교할 값 gap 선언
				int gap = point[i] - point[j];
				// 값이 음수일 경우 양수로 변환
				gap = gap < 0? gap*(-1): gap;
				
				// 값의 차이가 최소일 경우 min 값을 갱신하고, result 배열에 index 갱신
				if(min > gap) {
					min = gap;
					result[0] = i;
					result[1] = j;
				}
			}
		}
		System.out.println("result = " + Arrays.toString(result));
	}

}
