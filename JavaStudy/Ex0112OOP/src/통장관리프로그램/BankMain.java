package 통장관리프로그램;

public class BankMain {

	public static void main(String[] args) {
		
		Bankbook bank1 = new Bankbook();
		bank1.deposit(1000);
		bank1.withdraw(300);
		System.out.println(bank1.showMoney());

	}

}
