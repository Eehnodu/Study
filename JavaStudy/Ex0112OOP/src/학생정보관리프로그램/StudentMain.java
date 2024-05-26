package 학생정보관리프로그램;

public class StudentMain {

	public static void main(String[] args) {
		Student stu = new Student();
		
		stu.setName("임경남");
		stu.setNumber("20220458");
		stu.setAge(20);
		stu.setScoreJava(90);
		stu.setScoreWeb(25);
		stu.setScoreAndroid(50);
		
		System.out.println(stu.getName() + " " +stu.getScoreJava());
		
		Student stu2 = new Student("임경남" ,"20242222", 19);
		// new Student() ---> 객체를 생성하는 순간에 실행되는 메소드!
		// ****생성자(Constructor)****
	}
}
