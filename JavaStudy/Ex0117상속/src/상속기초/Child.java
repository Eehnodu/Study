package 상속기초;

public class Child extends Parent {
	
	@Override
	public void makeJjam() {
		System.out.println("맛있는 해물이 듬뿍 짬뽕을 만든다!! 뽀글뽀글~");
	}
	@Override
	public void makeTang() {
		System.out.println("맛있는 튀김이 바삭! 탕수육을 만든다!! 튀겨튀겨~");
	}
	
	
	/**
	 * @author hi
	 * @since 2024-01-17
	 * @return void
	 * @param x
	 */
	public void makeJja() {
		System.out.println("맛있는 짜장면은 만든다!! 후룩후룩~");
	}
}
