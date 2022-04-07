package object.gui.listener;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MouseEventAllExam extends JFrame {
	JLabel la = new JLabel("Follow Me!!");
	
	MouseEventAllExam() {
		setTitle("MouseListener 와 MouseMotionListener 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		MyMouseListener listener = new MyMouseListener();
		c.addMouseListener(listener);
		c.addMouseMotionListener(listener);
		
		c.setLayout(null);
		
		la.setSize(80, 20);
		la.setLocation(100, 100);
		c.add(la);
		
		setLocation(500, 100);
		setSize(400, 300);
		setVisible(true);
	}
	
	class MyMouseListener implements MouseListener, MouseMotionListener {

		@Override
		public void mouseDragged(MouseEvent e) {	// 마우스가 드래그되는 동안
			la.setLocation(e.getX(), e.getY());
			setTitle("mouseDragged(" + e.getX() + ", " + e.getY() + ")");
		}
		@Override
		public void mouseMoved(MouseEvent e) {		// 마우스가 움직이는 동안
			la.setLocation(e.getX(), e.getY());
			setTitle("mouseMoved(" + e.getX() + ", " + e.getY() + ")");
		}
		@Override
		public void mouseClicked(MouseEvent e) {	// 마우스로 컴포넌트를 클릭하였을 때
			setTitle("mouseClicked : " + e.getClickCount());
		}
		@Override
		public void mousePressed(MouseEvent e) {	// 마우스 버튼이 눌러졌을 때
			la.setLocation(e.getX(), e.getY());
			setTitle("mousePressed(" + e.getX() + ", " + e.getY() + ")");
		}
		@Override
		public void mouseReleased(MouseEvent e) {	// 눌려진 버튼이 떼어졌을 때
			la.setLocation(e.getX(), e.getY());
			setTitle("mouseReleased(" + e.getX() + ", " + e.getY() + ")");
		}
		@Override
		public void mouseEntered(MouseEvent e) {	// 마우스가 컴포넌트 위에 올라갈 때
			Component comp = (Component)e.getSource();
			comp.setBackground(Color.YELLOW);
		}
		@Override
		public void mouseExited(MouseEvent e) {		// 마우스가 컴포넌트에서 내려올 때
			Component comp = (Component)e.getSource();
			comp.setBackground(Color.MAGENTA);
		}
		
	}

	public static void main(String[] args) {
		new MouseEventAllExam();
	}

}
