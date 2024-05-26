package ArrayList;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {

		// ArrayList
		// : 크기가 가변적인 배열과 같은 형태를 가진 **클래스**
		
		// 1. ArrayList 생성
		// : 레퍼런스 타입의 데이터만 저장할 수 있다.
		// String, Pokemon ....
		
		ArrayList<String> list = new ArrayList<String>();
		// 제네릭 기법 -> 자바 책 390p
		
		// 2. 데이터 추가하기
		list.add("가"); list.add("나"); list.add("다");
		System.out.println(list.get(0)); 
		System.out.println(list.get(1)); 
		System.out.println(list.get(2));
		list.add(2,"라");
		System.out.println(list.get(2));
		list.remove(2);
		System.out.println(list.get(2));
		System.out.println(list.size());
		list.removeAll(list);
		System.out.println(list.size());
	}

}
