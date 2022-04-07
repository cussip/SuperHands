package object.gui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//-----------------------------------------------------------------------------------------------------------
// public class MiniOmok extends JFrame implements MouseListener
//-----------------------------------------------------------------------------------------------------------
public class MiniOmok extends JFrame implements MouseListener {

	//-----------------------------------------------------------------------------------------------------------
	// 변수 선언, 초기화
	//-----------------------------------------------------------------------------------------------------------
	final	int	LINE_NUM		= 19;							// 바둑판의 줄 수
	final	int	LINE_WIDTH		= 30;							// 바둑판의 줄 간격
	final	int	BOARD_SIZE		= LINE_WIDTH * (LINE_NUM - 1);	// 바둑판의 크기
	final	int	STONE_SIZE		= (int)(LINE_WIDTH * 0.8);		// 돌의 크기

	final	int	X0;	// 바둑판의 시작위치 x좌표
	final	int Y0;	// 바둑판의 시작위치 y좌표
	
	final	int	FRAME_WIDTH;	// 프레임의 폭
	final	int	FRAME_HEIGHT;	// 프레임의 높이
	
	boolean	myTime	= false;	// 검은돌, 흰돌의 순서
	
	Image		img		= null;
	Graphics	gImg	= null;
	
	//-----------------------------------------------------------------------------------------------------------
	// 생성자
	//-----------------------------------------------------------------------------------------------------------
	MiniOmok(String title) {
		
		super(title);
		
		// Event Handler를 등록한다.
		addMouseListener(this);
		
		setVisible(true);	// Frame을 화면에 보이게 한다.
		// 화면에 보이기 전에는 Insets의 값을 구할 수가 없다.
		// Insets객체는 컨테이너의 경계를 표현한 것이다.
		// 이것은 컨테이너가 각 엣지에 남기지 않으면 안되는 공간을 지정합니다.
		// 공간은 곙계, 공백 공간, 또는 타이틀입니다.
		Insets insets = getInsets();
		System.out.println("insets.left   => " + insets.left);
		System.out.println("insets.right  => " + insets.right);
		System.out.println("insets.top    => " + insets.top);
		System.out.println("insets.bottom => " + insets.bottom);
		
		// 바둑판이 그려질 위치(LEFT, TOP)의 좌표 X0, Y0를 지정한다.
		X0 = insets.left + LINE_WIDTH;
		Y0 = insets.top  + LINE_WIDTH;
		System.out.println("X0:" + X0 + ", Y0:" + Y0);
		
		// Frame의 크기를 계산한다.
		FRAME_WIDTH		= BOARD_SIZE + LINE_WIDTH*2 + insets.left + insets.right;
		FRAME_HEIGHT	= BOARD_SIZE + LINE_WIDTH*2 + insets.top  + insets.bottom;
		
		// 바둑판의 바탕색을 설정한다.
		setBackground(new Color(206, 167, 61));
		
		// Frame을 화면의 지정된 위치에 계산된 크기로 보이게 한다.
		setBounds(300, 100, FRAME_WIDTH, FRAME_HEIGHT);
		
		// AWT에서 깜빡임을 줄이기 위해 더블 버퍼링을 구현하면
		// 필수적으로 쓰게 되는 메서드가 createImage()이다.
		img = createImage(FRAME_WIDTH, FRAME_HEIGHT);
		
		// getGraphics() : 컴포넌트의 Graphics 객체를 반환하는 메서드.
		// paint() 메서드를 오버라이드하지 않고도 컴포넌트에 그릴 수 있는 방법이 있는데
		// Component 클래스의 getGraphics() 메서드를 이용하는 것이다.
		// 이 메서드는 컴포넌트의 Graphics 객체의 레퍼런스를 반환한다.
		// 주의할 점은 컴포넌트가 보여질 수 없는 상태에서 getGraphics()를 호출하면 null이 반환된다.
		gImg = img.getGraphics();
		
		// 보드를 그린다.
		gImg.setColor(Color.BLACK);
		drawBoard(gImg);
		
		// Frame의 크기를 변경하지 못하게 한다.
		setResizable(false);
		
	} // End - MiniOmok(String title)

	//-----------------------------------------------------------------------------------------------------------
	// 바둑판 그리기
	//-----------------------------------------------------------------------------------------------------------
	public void drawBoard(Graphics g) {

		// 바둑판이 그려질 위치(LEFT, TOP)의 좌표 X0, Y0
		for(int i = 0; i < LINE_NUM; i++) {
			g.drawLine(X0, Y0 + i * LINE_WIDTH, X0 + BOARD_SIZE, Y0 + i * LINE_WIDTH);	// 가로줄
			g.drawLine(X0 + i * LINE_WIDTH, Y0,  X0 + i * LINE_WIDTH, Y0 + BOARD_SIZE);	// 세로줄
		}
	} // End - public void draw
	
	//-----------------------------------------------------------------------------------------------------------
	/*
	 * 원본 크기로 그리기
	 * img를 그래픽 영역의 (x,y)위치에 img의 원본 크기로 그린다.
	 * boolean g.drawImag(Image img, int x, int y, Color bgColor, ImageObserver observer)
	 * boolean g.drawImag(Image img, int x, int y, ImageObserver observer)
	 * img : 이미지 객체
	 * x, y : 이미지가 그려질 좌표
	 * bgColor : 이미지가 투명한 부분을 가지고 있을 때 투명한 부분에 칠해지는 색상
	 * observer : 이미지 그리기의 완료를 통보받는 객체 
	 * 
	 * 크기 조절하여 그리기
	 * img를 그래픽 영역의 (x,y)위치에 width X height의 크기로 조절하여 그린다.
	 * boolean g.drawImag(Image img, int x, int y, int width, int height, Color bgColor, ImageObserver observer)
	 * boolean g.drawImag(Image img, int x, int y, int width, int height, ImageObserver observer)
	 * width : 그려지는 폭으로서 픽셀 단위
	 * height : 그려지는 높이로서 픽셀 단위
	 * 
	 */
	
	/*
	 * paint(Graphics g)
	 * 컴포넌트의 paint() 메서드는 자신을 그릴 때 호출되는 메서드이다.
	 * 이 메서드는 컴포넌트가 다시 그려질 필요가 있을 때 자동으로 호출된다.
	 * paint() 메서드의 인수로 Graphics 객체(일반적으로 Graphic context라고 함)가 넘어온다.
	 * 컴포넌트의 일부를 다시 그릴 필요가 있으면 Graphics 객체를 이용하여 컴포넌트를 그린다.
	 * 프로그래머는 paint() 메서드를 오버라이드해서 컴포넌트에 원하는 그림이나 도형을 그릴 수 있다.
	 * 우측 상단의 최소화버튼, 최대화버튼 클릭, 창의 사이즈 변경, 창의 위치 변경, 
	 * 다른 화면에 가려졌다가 다시 보여질 경우 호출된다.
	 */
	//-----------------------------------------------------------------------------------------------------------
	
	//-----------------------------------------------------------------------------------------------------------
	// paint(Graphics g)
	//-----------------------------------------------------------------------------------------------------------
	public void paint(Graphics g) {
		if(img == null)	return;
		// 가상화면에 그려진 그림을 Frame에 복사한다.
		g.drawImage(img, 0, 0, this);
	} // End - public void paint(Graphics g)
	
	//-----------------------------------------------------------------------------------------------------------
	// MouseListener 구현 메서드
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();	// 마우스 포인터의 x좌표
		int y = e.getY();	// 마우스 포인터의 y좌표
		
		System.out.println("X0:" + X0 + ", Y0:" + Y0);
		System.out.println("x:" + x + ", y:" + y);
		
		// 1. x 또는 y의 값이 오목판의 사용가능한 범위를 벗어난 곳이면 메서드를 종료한다.
		//if(x < X0 - LINE_WIDTH / 2 ||
		//	 x > X0 + BOARD_SIZE + LINE_WIDTH / 2) 
		if(x < X0 - LINE_WIDTH / 2 ||
				   x > X0 + (LINE_NUM-1) * LINE_WIDTH + LINE_WIDTH / 2) {
			System.out.println("x축 낙석.....");
			return;
		}	
		
		if(y < Y0 - LINE_WIDTH / 2 ||
		   y > Y0 + BOARD_SIZE + LINE_WIDTH / 2) {
			System.out.println("y축 낙석.....");
			return;
		}
		
		//-----------------------------------------------------------------------------------------------------------
		// 2. x 와 y 의 값을 클릭한 곳에 가장 가까운 교차점으로 변경한다.
		//-----------------------------------------------------------------------------------------------------------
		//-----------------------------------------------------------------------------------------------------------
		// 첫번째 방법
		// x, y의 위치 값을 0,0을 생각해서 계산(반올림)하고 난 후에 X0, Y0를 더해준다.
		// x의 값에 폭의 절반 값을 더한 후에 LINE_WIDTH로 나누면 몫이 나온다.
		// 이 몫에 LINE_WIDTH를 곱하면 그려질 위치가 된다.
		//-----------------------------------------------------------------------------------------------------------
		System.out.println("반올림 전 x:" + x + ", y:" + y);
		//x = (x - X0 + LINE_WIDTH/2) / LINE_WIDTH * LINE_WIDTH + X0;
		//y = (y - Y0 + LINE_WIDTH/2) / LINE_WIDTH * LINE_WIDTH + Y0;
		//System.out.println("반올림 후 x:" + x + ", y:" + y);
		
		//-----------------------------------------------------------------------------------------------------------
		// 두번째 방법
		// 클릭한 곳의 위치 값을 LINE_WIDTH로 나누어서 나머지가 LINE_WIDTH의 절반이 넘으면 몫+LINE_WIDTH,
		// 클릭한 곳의 위치 값을 LINE_WIDTH로 나누어서 나머지가 LINE_WIDTH의 절반이 넘지 않으면 나머지를 버린다.
		//-----------------------------------------------------------------------------------------------------------
		/*
		int x1 = (x-X0) / LINE_WIDTH;	// 몫
		if( (x-X0) % LINE_WIDTH < LINE_WIDTH / 2)
			x = x1 * LINE_WIDTH + X0;
		else
			x = (x1+1) * LINE_WIDTH + X0;
		
		int y1 = (y-Y0) / LINE_WIDTH;	// 몫
		if( (y-Y0) % LINE_WIDTH < LINE_WIDTH / 2)
			y = y1 * LINE_WIDTH + Y0;
		else
			y = (y1+1) * LINE_WIDTH + Y0;
		System.out.println("반올림 후 x:" + x + ", y:" + y);
		*/
		
		//-----------------------------------------------------------------------------------------------------------
		// 세번째 방법 : 두번째 방법을 삼항 연산자로 구현
		//-----------------------------------------------------------------------------------------------------------
		/*
		int x1 = (x-X0) / LINE_WIDTH;	// 몫
		x = ( (x-X0) % LINE_WIDTH < LINE_WIDTH / 2) ? x1 * LINE_WIDTH + X0 : (x1+1) * LINE_WIDTH + X0;
		
		int y1 = (y-Y0) / LINE_WIDTH;	// 몫
		y = ( (y-Y0) % LINE_WIDTH < LINE_WIDTH / 2) ? y1 * LINE_WIDTH + Y0 : (y1+1) * LINE_WIDTH + Y0;
		*/
		
		//-----------------------------------------------------------------------------------------------------------
		// 네번째 방법 : 세번째 방법의 지역변수 x1, y1을 없애 봅시다.
		//-----------------------------------------------------------------------------------------------------------
		x = ( (x-X0) % LINE_WIDTH < LINE_WIDTH / 2) ? ((x-X0) / LINE_WIDTH) * LINE_WIDTH + X0 : (((x-X0) / LINE_WIDTH)+1) * LINE_WIDTH + X0;
		y = ( (y-Y0) % LINE_WIDTH < LINE_WIDTH / 2) ? ((y-Y0) / LINE_WIDTH) * LINE_WIDTH + Y0 : (((y-Y0) / LINE_WIDTH)+1) * LINE_WIDTH + Y0;
		
		System.out.println("반올림 후 x:" + x + ", y:" + y);

		
		//3. x와 y의 값에서 돌의 크기(STONE_SIZE)의 절반을 빼야 
		//   클릭한 곳에 돌이 위치한다.
		x -= STONE_SIZE / 2; 
		y -= STONE_SIZE / 2; 
		
		//4. 눌려진 버튼이 마우스 왼쪽 버튼이면 (x,y)위치에 검은 돌을 그리고,
		if(e.getModifiersEx() == MouseEvent.BUTTON1_DOWN_MASK) {
			if(myTime == false) {
				gImg.setColor(Color.BLACK);
				gImg.fillOval(x, y, STONE_SIZE, STONE_SIZE);
				myTime = true; //검은 돌을 그렸으므로 흰돌차례로 설정한다.
			} else {
				System.out.println("흰돌을 놓을 차례입니다.");
			}
		} else if(e.getModifiersEx() == MouseEvent.BUTTON3_DOWN_MASK) {
		//눌려진 버튼이 마우스 오른쪽 버튼이면 (x,y)위치에 흰 돌을 그린다.
			if(myTime == true) {
				gImg.setColor(Color.WHITE);
				gImg.fillOval(x, y, STONE_SIZE, STONE_SIZE);
				//흰색돌을 위해서 검은색 테두리를 그린다.
				gImg.setColor(Color.BLACK);
				gImg.drawOval(x, y, STONE_SIZE, STONE_SIZE);
				myTime = false;
			} else {
				System.out.println("검은돌을 놓을 차례입니다.");
			}
		}
		
		/*
		 * repaint()
		 * repaint() -> update() -> paint()
		 * paint() 메서드는 필요에 의해 자동으로 호출된다.
		 * 하지만 화면이 가려지지 않더라도 화면을 갱신해야할 경우가 생길 수 있다.
		 * 이 때는 repaint() 메서드를 호출하면 된다.
		 * repaint()가 호출되면 빠르게 update() 메서드가 호출되고
		 * update() 메서드는 컴포넌트를 원래의 모습대로 그린 후에 paint() 메서드를 호출한다.
		 */
		//5. repaint()를 호출한다.
		repaint();
		
	} // End - public void mousePressed(MouseEvent e)
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mouseReleased(MouseEvent e) {}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new MiniOmok("미니 오목");
	} // End - public static void main(String[] args)


} // End - public class MiniOmok extends JFrame implements MouseListener





















