package object.gui.listener;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class IndepClassListener extends JFrame {
	IndepClassListener() {
		setTitle("독립된 클래스로 이벤트 리스너 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();	// 작업영역 알아내기
		c.setLayout(new FlowLayout());	// 배치관리자 임명
		
		JButton btn = new JButton("Action");
		btn.addActionListener(new MyActionListener()); // 버튼에 Action Event를 등록한다.
		
		c.add(btn);
		setSize(260, 140);
		setVisible(true);
	}

	public static void main(String[] args) {
		new IndepClassListener();
	}

}

// 독립된 클래스로 이벤트 리스너를 만든다.
class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		
		// 버튼 위의 글자가 영문이면 한글로 바꾼다.
		if(b.getText().equals("Action"))
			b.setText("액션");
		else // 버튼 위의 글자가 한글이면 영문으로 바꾼다.
			b.setText("Action");
		
	}
	
}








