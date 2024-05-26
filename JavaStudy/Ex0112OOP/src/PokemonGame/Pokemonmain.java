package PokemonGame;

import java.util.Scanner;

public class Pokemonmain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		Pokemon poke1 = new Pokemon("피카츄", 100, 10, "백만볼트", "전기");
		Pokemon poke2 = new Pokemon("조로아", 80, 15, "깨물기", "악");
		
		
		while(true){
			
			System.out.println("포켓몬을 선택하세요");
			System.out.print("[1]피카츄 [2]조로아 >> ");
			int choice = sc.nextInt();
			
			if(choice == 1) {
				System.out.println("공격을 선택하세요");
				System.out.print("[1]일반공격 [2]스킬공격 >> ");
				int choiceatk = sc.nextInt();
				if(choiceatk == 1) {
					
					poke2.setHp(poke2.getHp() - poke1.getAtk());
					if(poke2.getHp()<=0) {
						poke2.setHp(0);
					}
					System.out.println(poke1.getName() + "의 hp : " + poke1.getHp());
					System.out.println(poke2.getName() + "의 hp : " + poke2.getHp());
					
					
				}else if(choiceatk == 2) {
					
					poke2.setHp((int)(poke2.getHp() -(poke1.getAtk()*1.5)));
					if(poke2.getHp()<=0) {
						poke2.setHp(0);
					}
					System.out.println(poke1.getName() + "!!!! " + poke1.getSkill() + "!!!!");
					System.out.println(poke1.getName() + "의 hp : " + poke1.getHp());
					System.out.println(poke2.getName() + "의 hp : " + poke2.getHp());
					
				}else {
					
					System.out.println("번호를 잘못누르셨습니다.");
				}
				
			}else if(choice == 2){	
				System.out.println("공격을 선택하세요");
				System.out.print("[1]일반공격 [2]스킬공격 >> ");
				int choiceatk = sc.nextInt();
				
				if(choiceatk == 1) {
					
					poke1.setHp(poke1.getHp() - poke2.getAtk());
					if(poke1.getHp()<=0) {
						poke1.setHp(0);
					}
					System.out.println(poke1.getName() + "의 hp : " + poke1.getHp());
					System.out.println(poke2.getName() + "의 hp : " + poke2.getHp());
					
				}else if(choiceatk == 2) {

					poke1.setHp((int)(poke1.getHp()-(poke2.getAtk()*1.5)));
					if(poke1.getHp()<=0) {
						poke1.setHp(0);
					}
					System.out.println(poke2.getName() + "!!!! " + poke2.getSkill() + "!!!!");
					System.out.println(poke1.getName() + "의 hp : " + poke1.getHp());
					System.out.println(poke2.getName() + "의 hp : " + poke2.getHp());
					
				}else {
					
					System.out.println("번호를 잘못누르셨습니다.");
				}
			}else {
				
				System.out.println("번호를 잘못 누르셨습니다.");
			}
			
			if(poke2.getHp() == 0) {
				System.out.println(poke1.getName() + "가 승리했습니다!!");
				break;
			}else if(poke1.getHp() == 0) {
				System.out.println(poke2.getName() + "가 승리했습니다!!");
				break;
			}

		}
	}

}
