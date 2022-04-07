package object.gui.listener;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MouseListenerExam extends JFrame {
	JLabel la = new JLabel("Hello");
	
	MouseListenerExam() {
		setTitle("마우스 리스너 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		// 작업 영역에 마우스 리스너를 부착한다.
		// c.addMouseListener(new MyMouseListener());
		c.addMouseListener(new MyMouseAdapter());
		
		c.setLayout(null);
		
		la.setSize(50, 22);
		la.setLocation(20, 20);
		c.add(la);
		
		setSize(800, 600);
		setLocation(400, 100);
		setVisible(true);
	}
	
	class MyMouseAdapter extends MouseAdapter {

		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();		// 마우스를 클릭한 x좌표 값
			int y = e.getY();		// 마우스를 클릭한 y좌표 값
			la.setLocation(x, y); 	// label의 좌표 값을 x,y로 변경한다.
			setTitle("좌표 : " + x + ", " + y);
		}
		
	}
	
	class MyMouseListener implements MouseListener {

		@Override
		public void mousePressed(MouseEvent e) {
			int x = e.getX();		// 마우스를 클릭한 x좌표 값
			int y = e.getY();		// 마우스를 클릭한 y좌표 값
			la.setLocation(x, y); 	// label의 좌표 값을 x,y로 변경한다.
			setTitle("좌표 : " + x + ", " + y);
		}
		@Override
		public void mouseClicked(MouseEvent e) {}
		@Override
		public void mouseReleased(MouseEvent e) {}
		@Override
		public void mouseEntered(MouseEvent e) {}
		@Override
		public void mouseExited(MouseEvent e) {}
		
	}

	public static void main(String[] args) {
		new MouseListenerExam();
	}

}
