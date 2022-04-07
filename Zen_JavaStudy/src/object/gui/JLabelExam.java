package object.gui;

import java.awt.*;
import javax.swing.*;

public class JLabelExam extends JFrame {
	
	JLabelExam() {
		setTitle("Label 연습");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JLabel textLabel = new JLabel("저는 길동이 입니다.");
		
		ImageIcon img = new ImageIcon("C:\\Tool\\workspace\\JavaStudy\\src\\images\\cat.jpg");
		JLabel imageLabel = new JLabel(img);
		
		ImageIcon icon = new ImageIcon("C:\\Tool\\workspace\\JavaStudy\\src\\images\\normalIcon.gif");
		JLabel label = new JLabel("안녕하세요?", icon, SwingConstants.CENTER);
		
		c.add(textLabel);	c.add(imageLabel);	c.add(label);
		setSize(400, 600);
		setVisible(true);
	}

	public static void main(String[] args) {
		new JLabelExam();
	}

}
