package Question5;

public class Question {

	public static void main(String[] args) {
		goBusan(new Train());
		goBusan(new Bus());
		goBusan(new Airplane());
	}
	
	private static void goBusan(vehicle b) {
		b.go();
	}

}
