package object.gui.graphic;

import java.awt.*;
import javax.swing.*;

public class paintPanelExam extends JFrame {
	paintPanelExam() {
		setTitle("그리기 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setContentPane(new MyPanel());
		
		setSize(300, 240);
		setVisible(true);
	}

	class MyPanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);	// 패널 내에 이전에 그려진 잔상을 지우기 위해서 호출한다.
			g.setColor(Color.BLUE);		// 파란색 선택
			// g.drawRect(x, y, width, height);
			g.drawRect(10, 10, 50, 50);
			
			g.setColor(Color.MAGENTA);
			g.drawRect(50, 50, 70, 50);
			
			g.setColor(Color.BLACK);
			g.drawRect(110, 100, 60, 100);
			
		}
	}
	
	public static void main(String[] args) {
		new paintPanelExam();
	}

}














