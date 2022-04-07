package object.gui.bingo2;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Bingo2 extends JFrame {
	
	final int SIZE = 5;	// 빙고판의 크기
	JButton[] btnArr = null;
	String[] animal = { // 버튼 위에 쓰여질 글자들
			"고양이", "강아지", "거북이", "토끼",   "사자",
			"기린",   "코끼리", "하마",   "펭귄",   "부엉이",
			"곰",     "닭",     "소",     "독수리", "올빼미",
			"호랑이", "원숭이", "캥거루", "고래",   "청설모",
			"두루미", "두더지", "여우",   "사슴",   "수달"
	};
	int[] bingNum = new int[SIZE*SIZE];	// 버튼위치에 숨겨져 있는 숫자를 담을 배열변수
	
	Bingo2(String title) {
		super(title);
		setLayout(new GridLayout(SIZE, SIZE));
		
		MyEventHandler handler = new MyEventHandler();
		addWindowListener(handler); // 프레임에 리스너를 장착시킨다. => x버튼이 활성화 된다.
		
		btnArr = new JButton[SIZE*SIZE]; // 빙고판의 모든 버튼을 담을 객체배열을 만든다.
		
		// 버튼 위치에 숨겨져 있는 숫자를 만든다.(1 ~ 25)
		// bingNum[?] 에 임의의 정수(1 ~ 25)를 겹치지 않게 저장한다.
		for(int i = 0; i < SIZE*SIZE; i++) {
			bingNum[i] = (int)(Math.random() * (SIZE*SIZE) + 1);
			if(i > 0) { // 맨 처음 뽑은 번호를 비교할 필요가 없다.
				for(int j = 0; j < i; j++) { // 지금 뽑은 번호가 앞의 방들에 있는 번호와 같은 것이 있으면
					if(bingNum[j] == bingNum[i])
						i--; // 번호를 다시 뽑는다.
				}
			}
		}
		
		for(int i = 0; i < SIZE*SIZE; i++)
			System.out.print(bingNum[i] + ",");

		// 프레임에 버튼을 추가한다.
		for(int i = 0; i < SIZE*SIZE; i++) {
			// 배열 animal의 값을 가지고 버튼 위에 쓰여질 이름으로 한다.
			btnArr[i] = new JButton(animal[i]);
			btnArr[i].addActionListener(handler);	// 버튼에 이벤트리스너를 부착시킨다.
			btnArr[i].setFont(new Font("Gulim", Font.BOLD, 24));
			getContentPane().add(btnArr[i]);		// 버튼을 프레임에 장착시킨다.
		}
		
		// 프레임이 나타날 위치와 크기를 설정한다.
		setBounds(500, 100, 600, 600);	// setBounds(x, y, width, height);
		setVisible(true);	// 프레임을 화면에 보이게 한다.
	}
	
	class MyEventHandler extends WindowAdapter implements ActionListener {
		// 버튼을 눌렀을 경우 작동하는 이벤트
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();
			
			for(int i = 0; i < SIZE*SIZE; i++) {
				if((JButton)btn == btnArr[i]) {
					System.out.println("눌려진 버튼 : " + i);
					btnArr[i].setFont(new Font("Gulim", Font.BOLD+Font.ITALIC, 28));
					btnArr[i].setText(String.valueOf(bingNum[i]));
				}
			}
			btn.setBackground(Color.YELLOW);
		}
		// 프레임의 우측 상단에 있는 x버튼(닫기버튼)을 누르면 실행시키는 이벤트
		@Override
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);	// 프레임을 눈에 안보이게 한다.
			e.getWindow().dispose();			// 프레임을 메모리에서 제거한다.
			System.exit(0);						// 프로그램을 종료한다.
		}
		
	}

	public static void main(String[] args) {
		new Bingo2("빙고 게임");
	}

}
