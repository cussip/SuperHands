package object.gui.listener;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class AnonymousClassListener extends JFrame {
	AnonymousClassListener() {
		setTitle("익명 클래스 리스너 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		JButton btn = new JButton("Action");
		c.add(btn);
		
		// 익명 클래스로 액션 이벤트 리스너 만들기
		btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton b = (JButton)e.getSource();
				if(b.getText().equals("Action"))
					b.setText("한글");
				else 
					b.setText("Action");
				
				setTitle(b.getText());
			}
		});
		
		setSize(260, 140);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AnonymousClassListener();
	}

}
