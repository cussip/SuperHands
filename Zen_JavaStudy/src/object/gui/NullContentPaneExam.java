package object.gui;

import java.awt.*;
import javax.swing.*;

public class NullContentPaneExam extends JFrame {

	NullContentPaneExam() {
		setTitle("배치관리자 없이 컴포넌트를 배치하기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container contentPane = getContentPane();
		contentPane.setLayout(null); // 컨텐트팬의 배치관리자를 제거한다.
		
		JLabel la = new JLabel("버튼을 눌러보세요!");
		
		la.setSize(240, 20);
		la.setLocation(240, 160);
		contentPane.add(la);
		
		// 9개의 버튼을 같은 크기로 만든다.
		// 위치는 좌측 상단에서 우측 하단 방향으로 배치한다.
		for(int i = 1; i < 10; i++) {
			JButton btn = new JButton(Integer.toString(i));
			btn.setSize(50, 30);
			btn.setLocation(i*20, i*20);
			contentPane.add(btn);
		}

		// 프레임의 크기
		setSize(400, 300);
		setVisible(true);
	}
	
	public static void main(String[] args) {
		new NullContentPaneExam();

	}

}











