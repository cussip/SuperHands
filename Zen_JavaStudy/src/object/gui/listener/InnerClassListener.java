package object.gui.listener;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class InnerClassListener extends JFrame {

	InnerClassListener() {
		setTitle("내부 클래스 리스너 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener());
		
		c.add(btn);
		setSize(260, 140);
		setVisible(true);
	}
	
	// 내부 클래스로 Action Listener를 작성한다.
	// private으로 선언하여 외부에서 사용할 수 없게 한다.
	private class MyActionListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton b = (JButton)e.getSource();
			if(b.getText().equals("Action"))
				b.setText("액션");
			else 
				b.setText("Action");
			
			setTitle(b.getText());
		}
	}
	
	public static void main(String[] args) {
		new InnerClassListener();
	}

}
