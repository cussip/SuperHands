package object.gui;

import java.awt.*;
import javax.swing.*;

public class RadioButtonExam extends JFrame {
	RadioButtonExam() {
		setTitle("라디오 버튼 만들기");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Container c = getContentPane();
		c.setLayout(new FlowLayout());
		
		ButtonGroup g = new ButtonGroup();	// 버튼 그룹 객체를 생성한다.
		
		JRadioButton	apple	= new JRadioButton("사과");
		JRadioButton	pear	= new JRadioButton("배");
		JRadioButton	cherry	= new JRadioButton("키위");
		
		ButtonGroup g2	= new ButtonGroup();
		JRadioButton	banana	= new JRadioButton("바나나");
		JRadioButton	grape	= new JRadioButton("포도");
		
		// 라디오 버튼들을 버튼 그룹에 소속시킨다.
		g.add(apple);	g.add(pear);	g.add(cherry);
		g2.add(banana);	g2.add(grape);
		
		// 라디오 버튼들을 화면에 보이게 하려면, 컨텐트팬에 부착시켜야 한다.
		c.add(apple);	c.add(pear);	c.add(cherry);	c.add(banana);	c.add(grape);
		
		setSize(300, 200);
		setVisible(true);
	}

	public static void main(String[] args) {
		// RadioButtonExam 클래스를 생성하면, 생성자에 있는 내용이 실행된다.
		new RadioButtonExam(); 
	}

}
