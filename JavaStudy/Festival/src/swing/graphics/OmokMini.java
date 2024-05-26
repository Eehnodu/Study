package swing.graphics;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

//-----------------------------------------------------------------------------------------------------------
// public class OmokMini extends JFrame implements MouseListener
//-----------------------------------------------------------------------------------------------------------
public class OmokMini extends JFrame implements MouseListener {
	
	final int LINE_NUM = 19; // 바둑판의 줄 수
	final int LINE_WIDTH = 30; // 바둑판의 줄 간격
	final int BOARD_SIZE = LINE_WIDTH * (LINE_NUM - 1); // 바둑돌을 놓는 크기
	final int STONE_SIZE = (int)(LINE_WIDTH * 0.8); // 돌이 크기
	
	final int X0; // 바둑판 격자의 시작위치 x좌표
	final int Y0; // 바둑판 격자의 시작위치 y좌표
	
	final int FRAME_WIDTH; // Frame의 폭
	final int FRAME_HEIGHT; // Frame의 높이
	
	Image img = null;
	Graphics gImg = null;
	
	boolean myTime = false; // 검은돌, 흰돌의 순서를 나타내는 변수
	
	// 오목 판별을 위해서 필요한 변수들
	private int[][] map = new int[LINE_NUM][LINE_NUM]; // 오목판에 놓은 돌의 색을 저장할 배열 변수
	public static final int BLACK = 1, WHITE = -1; // 흑과 백을 나타내는 상수
	private int color = BLACK; // 게임을 시작할 때 돌의 색깔
	
	//-----------------------------------------------------------------------------------------------------------
	// 생성자
	//-----------------------------------------------------------------------------------------------------------
	public OmokMini(String title) {
		super(title);
		
		// Event Handler를 등록한다.
		addMouseListener(this);
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0); // 우측상단의 x버튼을 누르면 프로그램을 종료한다.
			}
		});
		
		setBackground(new Color(206, 167, 61)); // 바둑판 배경 설정
		
		setVisible(true); // Frame을 화면에 보이게 한다.
		Insets insets = getInsets(); // 화면이 보이기 전에는 Insets의 값을 구할 수가 없다.
		
		// 오목판이 그려질 위치(LEFT, TOP)의 좌표 X0, Y0을 지정한다.
		X0 = insets.left + LINE_WIDTH;
		Y0 = insets.top + LINE_WIDTH;
		
		// Frame의 크기를 계산한다.
		FRAME_WIDTH = BOARD_SIZE + LINE_WIDTH*2 + insets.left + insets.right;
		FRAME_HEIGHT = BOARD_SIZE + LINE_WIDTH*2 + insets.top + insets.bottom;
		
		// Frame을 화면의 (100, 100)의 위치에 계산된 크기로 보이게 한다.
		setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		
		// awt에서 깜빡임을 줄이기 위해서 더블 버퍼링을 구현하면
		// 필수적으로 쓰게 되는 메서드가 createImage()이다.
		img = createImage(FRAME_WIDTH, FRAME_HEIGHT);
		gImg = img.getGraphics();
		
		gImg.setColor(Color.BLACK);
		setResizable(false); // Frame의 크기를 변경하지 못하게 한다.
		drawBoard(gImg); // 바둑판에 줄을 그린다.
	}
	//-----------------------------------------------------------------------------------------------------------
	// public void paint(Graphics g)
	//-----------------------------------------------------------------------------------------------------------
	public void paint(Graphics g) {
		if(img == null) return;
		g.drawImage(img, 0, 0, this); // 가상화면에 그려진 그림을 Frame에 복사한다.
	} // End - public void paint(Graphics g)
	//-----------------------------------------------------------------------------------------------------------
	// 바둑판에 줄을 그린다. 
	//-----------------------------------------------------------------------------------------------------------
	public void drawBoard(Graphics g) {
		for(int i = 0; i < LINE_NUM; i++) {
			g.drawLine(X0, Y0 + i*LINE_WIDTH, X0 + BOARD_SIZE, Y0 + i*LINE_WIDTH); // 가로 줄
			g.drawLine(X0 + i*LINE_WIDTH, Y0, X0 + i*LINE_WIDTH, Y0 + BOARD_SIZE); // 세로 줄
		}
		
	} // End - public void drawBoard(Graphics g)
	//-----------------------------------------------------------------------------------------------------------
	// MouseListener 구현 : 마우스로 돌을 놓았을 때
	//-----------------------------------------------------------------------------------------------------------
	public void mousePressed(MouseEvent e) {
		
		int x = e.getX(); // 마우스를 클릭한 곳의 x좌표
		int y = e.getY(); // 마우스를 클릭한 곳의 y좌표
		System.out.println("[" + x + "][" + y + "]");
		
		
		// 1. x 또는 y의 값이 바둑판의 바깥을 벗어난 곳이면 메서드를 종료한다.
		if(x < X0 - LINE_WIDTH/2 || x > X0 + (LINE_NUM-1)*LINE_WIDTH+LINE_WIDTH/2) return;
		if(y < Y0 - LINE_WIDTH/2 || y > Y0 + (LINE_NUM-1)*LINE_WIDTH+LINE_WIDTH/2) return;
		
		// 2. x와 y의 값을 클릭한 곳에서 가장 가까운 교차점으로 변경한다. (반올림)
		// x - X0 => X0로 부터 떨어진 길이
		// x - X0 + LINE_WIDTH/2 => X0로 부터 떨어진길이 + 빈칸을 더한 위치가
		// x가 위치했던 영역인가? 아니면 x가 위치했던 영역보다 더 큰 위치인가?
		x = (x - X0 + LINE_WIDTH/2) / LINE_WIDTH * LINE_WIDTH + X0;
		y = (y - Y0 + LINE_WIDTH/2) / LINE_WIDTH * LINE_WIDTH + Y0;
		
		// 마우스가 클릭한 곳(교차점)의 값을 map의 좌표로 계산한다.
		int mx = (int)( (x - X0) / LINE_WIDTH);
		int my = (int)( (y - Y0) / LINE_WIDTH);
		
		// 해당 좌표에 이미 다른 돌이 놓여져 있으면 빠져 나온다.
		if(map[mx][my] == BLACK || map[mx][my] == WHITE) {
			JOptionPane.showMessageDialog(null, "돌 위에 놓을 수 없습니다.");
			return;
		}
		
		// 3. x와 y의 값에서 돌의 크기(STONE_SIZE)의 절반을 빼야 클릭한 곳의 가장 가까운 교차점에 돌이 그려진다.
		x -= STONE_SIZE / 2;
		y -= STONE_SIZE / 2;
		
		// 4. 눌려진 버튼이 마우스의 왼쪽 버튼이면, (x, y)의 위치에 검을 돌을 그리고
		if(e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
			color = BLACK;
			if(myTime == false) { // 검은 돌을 놓을 차례이면
				gImg.setColor(Color.BLACK);
				gImg.fillOval(x, y, STONE_SIZE, STONE_SIZE);
				
				map[mx][my] = color;
				// 오목이 되었는지 검사한다.
				if(judgment(new Point(mx, my), color)) {
					JOptionPane.showMessageDialog(null, "검은 돌이 이겼습니다.");
				}
				
				myTime = true; // 검은 돌을 놓았으므로 흰 돌을 놓을 차례로 변경한다.
			} else {
				System.out.println("흰 돌을 놓을 차례입니다.");
			}
		// 눌려진 버튼이 마우스의 오른쪽 버튼이면, (x, y)의 위치에 흰 돌을 그린다.
		} else if(e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) {
			color = WHITE;
			if(myTime == true) { // 흰 돌을 놓을 차례이면
				gImg.setColor(Color.WHITE);
				gImg.fillOval(x, y, STONE_SIZE, STONE_SIZE);
				// 흰 돌은 검은색 테두리를 그린다.
				gImg.setColor(Color.BLACK);
				gImg.drawOval(x, y, STONE_SIZE, STONE_SIZE);
				
				map[mx][my] = color;
				// 오목이 되었는지 검사한다.
				if(judgment(new Point(mx, my), color)) {
					JOptionPane.showMessageDialog(null, "흰 돌이 이겼습니다.");
				}
				
				myTime = false; // 흰 돌을 놓았으므로 검은 돌을 놓을 차례로 변경한다.
			} else {
				System.out.println("검은 돌을 놓을 차례입니다.");
			}
		}
		
		// 5. repaint()호출한다.
		repaint();
		
	} // End - public void mousePressed(MouseEvent e)
	public void mouseClicked(MouseEvent e) {}
	public void mouseEntered(MouseEvent e) {}
	public void mouseExited(MouseEvent e) {}
	public void mouseReleased(MouseEvent e) {}
	//-----------------------------------------------------------------------------------------------------------
	// 지금 둔 돌 주위로 연속해서 같은 색깔의 돌이 4개면 오목이 성립된다.
	//
	// 지금 둔 돌을 기준으로 4가지 진행방향(―, ｜, ／, ＼)의 양방향으로 더한 값이 4이면 오목이 성립된다.
	//-----------------------------------------------------------------------------------------------------------
	private boolean judgment(Point p, int color) {
		
		// ― (왼쪽 방향 개수 + 오른쪽 방향 개수)
		if(count(p, -1, 0, color) + count(p, 1, 0, color) == 4) return true;
		
		// ｜ (위쪽 방향 개수 + 아래쪽 방향 개수)
		if(count(p, 0, -1, color) + count(p, 0, 1, color) == 4) return true;
		
		// ／ (좌측 하단 방향 개수 + 우측 상단 방향 개수)
		if(count(p, -1, 1, color) + count(p, 1, -1, color) == 4) return true;
		
		// ＼ (우쪽 하단 방향 개수 + 좌측 상단 방향 개수)
		if(count(p, -1, 1, color) + count(p, -1, -1, color) == 4) return true;
		
		return false;
	} // End - private boolean judgment(Point p, int color)	
	
	//-----------------------------------------------------------------------------------------------------------
	// 지금 둔 돌 주위로 연속해서 같은 색깔의 돌의 갯수를 반환하는 메서드
	// count(Point p, int dx, int dy, int color) : count(좌표, x축 진행방향, y축 진행방향, 돌의 색깔)
	//-----------------------------------------------------------------------------------------------------------
	private int count(Point p, int dx, int dy, int color) {
		
		int count = 0;
		for( ;
				(p.x + (count + 1) * dx) >= 0 && (p.x + (count + 1) * dx) <= 18 &&
				(p.y + (count + 1) * dy) >= 0 && (p.y + (count + 1) * dy) <= 18 &&
				map[p.x + (count + 1) * dx][p.y + (count + 1) * dy] == color
			; count++);
				
		return count;
	} // End - private int count(Point p, int dx, int dy, int color)
	
	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new OmokMini("미니 오목 게임");

	} // End - public static void main(String[] args)

} // End - public class OmokMini extends JFrame implements MouseListener
