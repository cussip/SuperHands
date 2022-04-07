package object.gui.graphic;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//-----------------------------------------------------------------------------------------------------------
// public class DrawOvalMouseExam extends JFrame
//-----------------------------------------------------------------------------------------------------------
public class DrawOvalMouseExam extends JFrame {

	//-----------------------------------------------------------------------------------------------------------
	// 생성자 : DrawOvalMouseExam()
	//-----------------------------------------------------------------------------------------------------------
	DrawOvalMouseExam() {
		setTitle("마우스를 드래그하여 타원 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setSize(800, 800);
		setLocation(500, 100);
		setVisible(true);
	} // End - DrawOvalMouseExam()
	
	//-----------------------------------------------------------------------------------------------------------
	// class MyPanel extends JPanel
	// 타원을 그릴 패널. 이 패널에 마우스 리스너를 구현한다.
	//-----------------------------------------------------------------------------------------------------------
	class MyPanel extends JPanel {
		Point start = null, end = null;	// 마우스의 시작 점과 끝 점에 사용
		
		//-----------------------------------------------------------------------------------------------------------
		// 생성자 : public MyPanel()
		//-----------------------------------------------------------------------------------------------------------
		public MyPanel() {
			MyMouseListener listener = new MyMouseListener();
			
			// listener를 아래의 두 리스너로 공통으로 등록한다.
			addMouseListener(listener);
			addMouseMotionListener(listener);
		} // End - public MyPanel()
		
		//-----------------------------------------------------------------------------------------------------------
		// class MyMouseListener extends MouseAdapter
		//-----------------------------------------------------------------------------------------------------------
		class MyMouseListener extends MouseAdapter {

			//-----------------------------------------------------------------------------------------------------------
			// public void mousePressed(MouseEvent e)
			//-----------------------------------------------------------------------------------------------------------
			@Override
			public void mousePressed(MouseEvent e) {
				// 마우스를 클릭한 곳의 좌표값을 가져온다.
				start = e.getPoint();
			} // ENd - public void mousePressed(MouseEvent e)

			//-----------------------------------------------------------------------------------------------------------
			// public void mouseDragged(MouseEvent e)
			//-----------------------------------------------------------------------------------------------------------
			@Override
			public void mouseDragged(MouseEvent e) {
				// 마우스를 드래그한 곳의 좌표값을 가져온다.
				end = e.getPoint();
				System.out.println(end.x + ":" + end.y);
				// repaint()가 호출되면 자바 플랫폼에 의해서 MyPanel의 paintComponent()가 호출된다.
				repaint();
			} // End - public void mouseDragged(MouseEvent e)
			
		} // End - class MyMouseListener extends MouseAdapter

		//-----------------------------------------------------------------------------------------------------------
		// protected void paintComponent(Graphics g)
		// start와 end 사이의 타원을 그린다.
		//-----------------------------------------------------------------------------------------------------------
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			if(start == null)	// 타원이 만들어지지 않은 상태
				return;
			
			g.setColor(new Color(0xFF00FF));
			
			// g.drawOval(x, y, width, height);
			
			// Math.min(start.x,  end.x);
			// 원을 그릴 때 x의 값으로 설정할 수 있는 것이 시작x와 종료x 두가지가 존재한다.
			// 이중 작은 값을 기준으로 만든다. <== 원이 그려지는 것은 왼쪽에서 오른쪽 방향으로 그려지기 때문에
			// 원을 그릴 때 y의 값으로 설정할 수 있는 것이 시작y와 종료y 두가지가 존재한다.
			// 이중 작은 값을 기준으로 만든다. <== 원이 그려지는 것은 윗쪽에서 아래쪽 방향으로 그려지기 때문에
			int	x 		= Math.min(start.x,  end.x);
			int y 		= Math.min(start.y,  end.y);
			// Math.abs(start.x - end.x)
			// 폭과 높이가 음수이면 화면에 보이지 않게 된다.
			// 폭과 높이의 거리 차이를 양수로 만들어서 그린다.
			int width	= Math.abs(start.x - end.x);
			int height	= Math.abs(start.y - end.y);
			
			g.drawOval(x, y, width, height);
			
		} // End - protected void paintComponent(Graphics g)
		
		
	} // End - class MyPanel extends JPanel

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new DrawOvalMouseExam();
	} // End - public static void main(String[] args)

} // End - public class DrawOvalMouseExam extends JFrame
