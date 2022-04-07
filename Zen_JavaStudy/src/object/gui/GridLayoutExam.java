package object.gui;

import java.awt.*;
import javax.swing.*;

public class GridLayoutExam extends JFrame {

	public GridLayoutExam() { // 기본 생성자
		super("GridLayout 연습"); // setTitle("GridLayout 연습"); 와 같다.
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		
		// 1행 10열의 배치관리자를 사용한다.
		contentPane.setLayout(new GridLayout(1, 10));
		// contentPane.add(new Button("OK"));
		// 반복문을 이용하여 버튼 10개를 만들고, contentPane에 붙인다.
		for(int i = 0; i < 10; i++) {
			String text = Integer.toString(i);
			JButton button = new JButton(text);
			contentPane.add(button);
		}
		
		setSize(500, 200);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new GridLayoutExam();

	}

}










