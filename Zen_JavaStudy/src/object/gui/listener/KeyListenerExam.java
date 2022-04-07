package object.gui.listener;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

// Enter 키를 누르면 임의의 배경색으로 변경시키자. 
public class KeyListenerExam extends JFrame {
	JLabel la = new JLabel("[Enter] 키를 누르면 배경색이 바뀝니다.");
	
	KeyListenerExam() {
		super("키 리스너 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(la);
		c.addKeyListener(new MyKeyListener());
		
		setSize(300, 200);
		setVisible(true);
		c.requestFocus(); // 컨텐트팬에 포커스를 설정한다.
	}
	
	class MyKeyListener extends KeyAdapter {

		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("keyPressed.....");
			// 임의의 색상을 만들기 위해서 랜덤하게 r,g,b를 생성한다.
			int	r = (int) (Math.random() * 256);
			int g = (int) (Math.random() * 256);
			int b = (int) (Math.random() * 256);

			switch(e.getKeyChar()) {
			case '\n':	// Enter 키 입력
				la.setText("r:" + r + ", g:" + g + ", b:" + b);
				getContentPane().setBackground(new Color(r, g, b));
				break;
			case 'q':
				System.exit(0);	// 프로그램 종료
			}
		}
		
	}

	public static void main(String[] args) {
		new KeyListenerExam();
	}

}
