package object.gui.graphic;

import java.awt.*;
import javax.swing.*;

public class FigureExam extends JFrame {
	
	FigureExam() {
		setTitle("그리기 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(new MyPanel());
		setSize(1000, 1000);
		setVisible(true);
	}
	
	class MyPanel extends JPanel {

		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			// 직선 그리기
			g.setColor(Color.RED);
			g.drawLine(20, 40, 900, 80);
			
			// 원 그리기
			// g.drawOval(x, y, width, height)
			g.setColor(new Color(255, 0, 255));
			g.drawOval(40, 80, 300, 280);
			
			// 원 그리기
			g.setColor(new Color(255, 0, 255));
			g.drawOval(540, 80, 200, 280);
			
			// 사각형 그리기
			// g.drawRect(x, y, width, height)
			g.setColor(new Color(0xff00ff));
			g.drawRect(80, 400, 200, 300);
			
			// 둥근 모서리 사각형 그리기
			// g.drawRoundRect(x, y, width, height, 깍이는 width, 깍이는 height)
			g.setColor(new Color(0x223322));
			g.drawRoundRect(500, 400, 300, 200, 40, 60);
			
			// 원호 그리기
			// g.drawArc(시작좌표 x, 시작좌표 y, width, height, 시작각도, 종료각도)
			// 0도(3시), 90도(12시), 180(9시), 270(6시)
			g.setColor(Color.RED);
			g.drawArc(600, 600, 80, 80, 90, 270);
			g.setColor(Color.BLACK);
			g.drawArc(800, 700, 80, 120, 0, 270);
			
			// 폐다각형 그리기
			int[]	x = {80,  40,  80, 120};
			int[]	y = {40, 120, 200, 120};
			g.drawPolygon(x, y, 3);
			
		}
		
	}

	public static void main(String[] args) {
		new FigureExam();
	}

}
