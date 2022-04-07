package object.gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JComponentExam extends JFrame {

	JComponentExam() {
		super("JComponent의 공통 메서드 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn1 = new JButton("Magenta/Yellow Button");
		JButton btn2 = new JButton("Disabled Button");
		JButton btn3 = new JButton("getX(), getY()");
		
		// 공통 메서드를 사용한다.
		btn1.setBackground(Color.YELLOW);
		btn1.setForeground(Color.MAGENTA);
		
		btn2.setEnabled(false);
		
		btn3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("세번째 버튼이 눌렸습니다.");
				
				JButton b = (JButton) e.getSource();
				setTitle(b.getX() + ":" + b.getY());
			}
		});
		
		c.add(btn1);	c.add(btn2);	c.add(btn3);
		setSize(240, 200);
		setLocation(500, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new JComponentExam();
	}

}










