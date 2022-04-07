package object.gui.graphic;

import java.awt.*;
import javax.swing.*;

public class ColorFontExam extends JFrame {

	ColorFontExam() {
		setTitle("문자열 그리기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setSize(900, 900);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			// TODO Auto-generated method stub
			super.paintComponent(g);
			
			g.setColor(Color.BLUE);	// 
			g.drawString("재미있는 자바", 30, 50);
			
			//g.setColor(Color.GREEN);
			g.setColor(new Color(255, 0, 0));	// 새빨간색
			g.setFont(new Font("Gulim", Font.ITALIC+Font.BOLD, 34));
			g.drawString("정말로 재미있나요?", 50, 80);
			
			g.setColor(new Color(0xFF00FF));
			
			for(int i = 1; i <= 10; i++) {
				g.setFont(new Font("Batang", Font.ITALIC+Font.BOLD, 10*i));
				g.drawString("엄청나게 재미있어요.", 30, 100+i*70);
			}
		}
		
	}
	
	public static void main(String[] args) {
		new ColorFontExam();
	}

}














