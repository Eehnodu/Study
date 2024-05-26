package ArrayList;

import java.util.ArrayList;

public class StudentMain {

	public static void main(String[] args) {
		ArrayList<Student> list = new ArrayList<Student>();
		list.add(new Student("ㅇㅎㅅ",20));
		list.add(new Student("ㄱㅇㅂ",21));
		list.add(new Student("ㅈㅂㅅ",22));
		list.add(new Student("ㅇㅇㅇ",23));
		
		System.out.println("==== 팁원 정보 ====");
		for(Student s : list) {
			System.out.println(s.getName() + "\t" + s.getAge());
		}
	}
}