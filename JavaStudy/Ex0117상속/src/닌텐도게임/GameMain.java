package 닌텐도게임;

public class GameMain {

	public static void main(String[] args) {
		Pokemon p = new Pokemon();
		Mario m = new Mario();
		Zelda z = new Zelda();
		Dongmul d = new Dongmul();
		
		insert(p);
		insert(m);
		insert(z);
		insert(d);
		
	}
	
	private static void insert(GameChip game) {
		game.gameStart();
	}

}
