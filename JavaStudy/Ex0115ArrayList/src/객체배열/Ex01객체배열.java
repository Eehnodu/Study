package 객체배열;

import java.util.ArrayList;
import java.util.Arrays;

public class Ex01객체배열 {

	public static void main(String[] args) {		
		ArrayList<Integer> bag2 = new ArrayList<>();
		Pokemon[] bag = new Pokemon[3];		
		bag[0] = new Pokemon("피카츄", 100, 15, "백만볼트", "전기");
		bag[1] = new Pokemon("파이리", 90, 12, "화염방사", "불");
		bag[2] = new Pokemon("꼬부기", 88, 14, "물대포", "물");
		
		System.out.println("==== 포켓몬 정보 출력 =====");
		for(int i = 0; i<bag.length; i++) {
			bag[i].show();
		}

		for(Pokemon p: bag){
			p.show();
		}
	}

}
