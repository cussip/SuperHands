package object.gui;

import java.awt.*;
import javax.swing.*;

public class ButtonImageExam extends JFrame {
	ButtonImageExam() {
		setTitle("이미지 버튼 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	// 닫기버튼(x) 활성화
		
		Container c = getContentPane();	// 작업영역의 정보를 알아낸다.
		c.setLayout(new FlowLayout());	// 배치관리자를 FlowLayout으로 임명한다.
		
		// 이미지 아이콘을 3개 만든다. 
		ImageIcon	normalicon		= new ImageIcon("C:\\Tool\\workspace\\JavaStudy\\src\\images\\normalicon.gif");
		ImageIcon	rollovericon	= new ImageIcon("C:\\Tool\\workspace\\JavaStudy\\src\\images\\rollovericon.gif");
		ImageIcon	pressedicon		= new ImageIcon("C:\\Tool\\workspace\\JavaStudy\\src\\images\\pressedicon.gif");
		
		JButton btn = new JButton("따르릉", normalicon);
		btn.setPressedIcon(pressedicon);
		btn.setRolloverIcon(rollovericon);
		
		c.add(btn);
		setSize(300, 160);	// 프레임의 사이즈
		setVisible(true);	// 프레임을 화면에 보여준다.
	}

	public static void main(String[] args) {
		new ButtonImageExam();
	}

}













