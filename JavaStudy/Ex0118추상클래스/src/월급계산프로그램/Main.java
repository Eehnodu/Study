package 월급계산프로그램;

public class Main {

	public static void main(String[] args) {
		RegularEmployee re = new RegularEmployee("0001", "ㄱㅇㅂ", 100, 20);
		TempEmployee te = new TempEmployee("0001", "ㄴㅇㄹ", 12000);
		PartTimeEmployee pa = new PartTimeEmployee("0001", "ㅇㄹㄹ", 2400, 10);
		
		
		System.out.println(re.getMoneyPay());
		System.out.println(re.print()+"\n");
		System.out.println(te.getMoneyPay());
		System.out.println(te.print()+"\n");		
		System.out.println(pa.getMoneyPay());
		System.out.println(pa.print()+"\n");
	}

}
