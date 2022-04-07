package object.gui.listener;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class MovingTextEaxm extends JFrame {
	JPanel 	contentPane = new JPanel();
	JLabel	la			= new JLabel("GOOD");
	static	int	moving	= 10;
	
	MovingTextEaxm() {
		super("상,하,좌,우 키를 이용하여 글자 움직이기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.addKeyListener(new MyKeyListener());
		
		la.setLocation(30, 30);
		la.setSize(80, 22);
		la.setOpaque(true);
		la.setBackground(Color.MAGENTA);
		contentPane.add(la);
		
		setSize(600, 500);
		setVisible(true);
		
		contentPane.requestFocus();
	}
	
	class MyKeyListener extends KeyAdapter {
		@Override
		public void keyPressed(KeyEvent e) {
			int keyCode = e.getKeyCode();	// 입력된 키의 코드 값을 구한다.
			
			System.out.println(la.getX() + ":" + la.getY());
			
			switch(keyCode) {
			
				//contentPane.getWidth()  // 작업영역의 가로 길이
				//contentPane.getHeight() // 작업영역의 세로 길이
			
				case KeyEvent.VK_UP:
					if(la.getY() > 0) 
						la.setLocation(la.getX(), la.getY() - moving);	
					break;
				case KeyEvent.VK_DOWN:
					if(la.getY() < contentPane.getHeight() - la.getHeight())
						la.setLocation(la.getX(), la.getY() + moving);	
					break;
				case KeyEvent.VK_LEFT:
					if(la.getX() > 0) 
						la.setLocation(la.getX() - moving, la.getY());	
					break;
				case KeyEvent.VK_RIGHT:
					if(la.getX() < contentPane.getWidth() - la.getWidth())
						la.setLocation(la.getX() + moving, la.getY());	
					break;
			}
		}
	}

	public static void main(String[] args) {
		new MovingTextEaxm();
	}

}





