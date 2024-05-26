package OOP기초;


public class PersonMain {
	// 실행할 수 있는 공간
	public static void main(String[] args) {
		
		// 1. 설계도를 기반으로 객체를 생성
		// 자료형 변수명 = new 자료형();
		// 사람자료형을 만들기!! 변수명은 person
		Person person = new Person();
		System.out.println(person.name);
		System.out.println(person.age);
		System.out.println(person.gender);
		// field에 아무것도 넣어주지 않았을때는 기본값을 세팅된다.
		// String --> null
		// int -----> 0
		
		person.name = "김이박"; person.age = 26; person.gender = "남";
		System.out.println(person.name);
		System.out.println(person.age);
		System.out.println(person.gender);
		
		Person person2 = new Person();
		person2.name = "ㅇㅎㅅ"; person2.age = 28; person2.gender ="여";
		System.out.println(person2.name + "\n" + person2.age + "\n" + person2.gender);
		
		person2.talk();
	}

}
