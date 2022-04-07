package object.gui;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class CheckBoxExam extends JFrame {
	
	JCheckBox[] fruits 	= new JCheckBox[5];
	String[]	names	= {"사과", "바나나", "체리", "키위", "망고"};
	JLabel		sumLabel;
	
	CheckBoxExam() {
		setTitle("CheckBox");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		c.add(new JLabel("사과 2000원, 바나나 3000원, 체리 4000원, 키위 3500원, 망고 4500원"));
		MyItemListener listener = new MyItemListener();
		
		for(int i = 0; i < fruits.length; i++) {
			fruits[i] = new JCheckBox(names[i]);
			fruits[i].setBorderPainted(true);
			c.add(fruits[i]);
			fruits[i].addItemListener(listener);
		}
		
		sumLabel = new JLabel("현재 0원입니다.");
		c.add(sumLabel);
		
		setSize(440, 200);
		setVisible(true);
	}
	
	class MyItemListener implements ItemListener {
		int sum = 0;	// 선택한 과일들의 가격의 합산을 저장할 변수
		
		@Override
		public void itemStateChanged(ItemEvent e) {
			if(e.getStateChange() == ItemEvent.SELECTED) { // 체크박스를 선택한 상태
				if(e.getItem() == fruits[0])		sum	+= 2000;
				else if(e.getItem() == fruits[1])	sum	+= 3000;
				else if(e.getItem() == fruits[2])	sum	+= 4000;
				else if(e.getItem() == fruits[3])	sum	+= 3500;
				else if(e.getItem() == fruits[4])	sum	+= 4500;
			} else { // 체크박스의 선택을 해제한 상태
				if(e.getItem() == fruits[0])		sum	-= 2000;
				else if(e.getItem() == fruits[1])	sum	-= 3000;
				else if(e.getItem() == fruits[2])	sum	-= 4000;
				else if(e.getItem() == fruits[3])	sum	-= 3500;
				else if(e.getItem() == fruits[4])	sum	-= 4500;
			}
			sumLabel.setText("현재 " + sum + "원입니다.");
		}

		
	}
	

	public static void main(String[] args) {
		new CheckBoxExam();
	}

}
