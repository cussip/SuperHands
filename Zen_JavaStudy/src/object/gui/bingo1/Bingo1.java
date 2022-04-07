package object.gui.bingo1;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//-----------------------------------------------------------------------------------------------------------
// public class Bingo1
//-----------------------------------------------------------------------------------------------------------
public class Bingo1 extends JFrame {
	final int SIZE = 5;	// 빙고판의 크기
	JButton[] btnArr = null;
	String[] animal = { // 버튼 위에 쓰여질 글자들
			"고양이", "강아지", "거북이", "토끼",   "사자",
			"기린",   "코끼리", "하마",   "펭귄",   "부엉이",
			"곰",     "닭",     "소",     "독수리", "올빼미",
			"호랑이", "원숭이", "캥거루", "고래",   "청설모",
			"두루미", "두더지", "여우",   "사슴",   "수달"
	};
	
	Bingo1(String title) {
		super(title);
		setLayout(new GridLayout(SIZE, SIZE));
		
		MyEventHandler handler = new MyEventHandler();
		addWindowListener(handler);
		
		btnArr = new JButton[SIZE*SIZE];	// 25개의 버튼을 담을 객체배열을 만든다.
		
		// JFrame에 버튼을 추가한다.
		for(int i = 0; i < SIZE*SIZE; i++) {
			btnArr[i] = new JButton(animal[i]);
			btnArr[i].setFont(new Font("Gulim", Font.BOLD, 24));
			btnArr[i].addActionListener(handler);
			add(btnArr[i]);
		}
		
		setBounds(500, 100, 600, 600);	// setBounds(x, y, width, height);
		setVisible(true);
	} // End - Bingo1(String title)
	
	class MyEventHandler extends WindowAdapter implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			JButton btn = (JButton)ae.getSource();
			btn.setBackground(Color.LIGHT_GRAY); // 누른 버튼의 배경색을 밝은 회색으로 변경한다.
		}
		// Frame의 우측 상단의 x버튼(닫기 버튼)을 누르면 프로그램을 종료한다.
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);
			e.getWindow().dispose();
			System.exit(0);
		}
	}
	
	public static void main(String args[]) {
		Bingo1 win = new Bingo1("빙고 게임");
	} // End - public static void main(String args[])

} // End - public class Bingo1
