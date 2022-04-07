package object.gui;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.*;

public class ContentPaneExam extends JFrame {
	ContentPaneExam() {
		setTitle("ContentPane 알아보기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();	// 컨텐트팬 정보 알아내기
		contentPane.setBackground(Color.ORANGE);	// 배경색
		// FlowLayout() => 중앙정렬
		// FlowLayout(FlowLayout.LEFT) => 왼쪽정렬
		// FlowLayout(FlowLayout.LEFT, 수평간격, 수직간격)
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 40, 20));	// 컨텐트팬에 FlowLayout 배치관리자를 붙인다.
		
		contentPane.add(new JButton("OK"));
		contentPane.add(new JButton("Cancel"));
		contentPane.add(new JButton("Ignore"));
		
		setSize(400, 200);
		setLocation(200, 100);
		setVisible(true);
	}

	public static void main(String[] args) {
		new ContentPaneExam();
	}

}
