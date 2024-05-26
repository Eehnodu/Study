package MVC;

public class Music {
	
	   //---필드---
	   // 1. 노래 데이터의 제목
	   private String title;
	   // 2. 노래 데이터의 가수
	   private String singer;
	   // 3. 재생 시간
	   private int playTime;
	   // 4. 위치(주소값, 경로)
	   private String path;
	   
	   
	   
	   // ---메소드---
	   // 1. 모든 필드값을 채울 수 있는 생성자
	   public Music(String title, String singer, int playTime, String path) {
	      super();
	      this.title = title;
	      this.singer = singer;
	      this.playTime = playTime;
	      this.path = path;
	   }
	   // 2. 모든 필드의 getter 메소드만 만들기
	   public String getTitle() {
	      return title;
	   }

	   public String getSinger() {
	      return singer;
	   }

	   public int getPlayTime() {
	      return playTime;
	   }

	   public String getPath() {
	      return path;
	   }

}
