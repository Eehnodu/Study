package switch문;
import java.util.Scanner;

public class Ex02자판기프로그램 {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("금액을 입력하세요: ");
        int money = sc.nextInt();
        int itemPrice = 0;
        int menu;

        while (true) {
            System.out.println("메뉴를 고르세요.");
            System.out.print("1. 아우터(700원) 2. 이구동성(1000원) 3. 에그몽(500원) >> ");
            menu = sc.nextInt();

            switch (menu) {
                case 1:
                    itemPrice = 700;
                    break;
                case 2:
                    itemPrice = 1000;
                    break;
                case 3:
                    itemPrice = 500;
                    break;
                default:
                    System.out.println("올바른 메뉴를 선택하세요.");
                    continue; 
            }
            break; 
        }
        if (money < itemPrice) {
            System.out.println("돈이 부족합니다.");
            System.out.println("잔돈: " + money);
        } else {
            int change = money - itemPrice;
            System.out.println("잔돈: " + change);
            System.out.println("천원: " + change / 1000 + " 오백원: " + (change % 1000) / 500 + " 백원: " + (change % 500) / 100);
        }
    }
}