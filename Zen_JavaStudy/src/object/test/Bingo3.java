package object.test;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//-----------------------------------------------------------------------------------------------------------
// public class Bingo3 extends JFrame
//-----------------------------------------------------------------------------------------------------------
public class Bingo3 extends JFrame {
	
	//-----------------------------------------------------------------------------------------------------------
	// 게임에 필요한 변수 선언과 초기화
	//-----------------------------------------------------------------------------------------------------------
	final int SIZE = 5;	// 빙고판의 크기
	JButton[] btnArr = null;
	String[] animal = { // 버튼 위에 쓰여질 글자들
			"고양이", "강아지", "거북이", "토끼",   "사자",
			"기린",   "코끼리", "하마",   "펭귄",   "부엉이",
			"곰",     "닭",     "소",     "독수리", "올빼미",
			"호랑이", "원숭이", "캥거루", "고래",   "청설모",
			"두루미", "두더지", "여우",   "사슴",   "수달"
	};
	int[] bingoNum = new int[SIZE*SIZE];	// 버튼 위치에 숨겨져있는 숫자를 담을 배열변수
	private boolean[][] btnOX = new boolean[SIZE][SIZE]; // 빙고판 체크여부를 확인하기 위한 배열 변수
	
	int bingoCount = 0;	// 완성된 라인의 수를 저장할 변수
	//-----------------------------------------------------------------------------------------------------------
	// 생성자
	//-----------------------------------------------------------------------------------------------------------
	Bingo3() {
		this("빙고게임");
	}	
	Bingo3(String title) {
		super(title);
		setLayout(new GridLayout(SIZE, SIZE));
		
		MyEventHandler handler = new MyEventHandler();
		addWindowListener(handler);
		
		btnArr = new JButton[SIZE*SIZE]; // SIZE*SIZE개의 버튼을 담을 객체배열을 만든다.
		// 버튼 위치에 숨겨져 있는 숫자를 만든다.(1~25 사이의 정수를 중복되지 않게 만든다.)
		// bingoNum[?] = 랜덤한 정수
		
		for(int i = 0; i < SIZE*SIZE; i++) {
			bingoNum[i] = (int)(Math.random() * 25) + 1;
			for(int j = 0; j < i; j++) {
				if(bingoNum[j] == bingoNum[i]) {
					i--;
				}
			}
		}
		
		// JFrame에 버튼을 추가한다.
		for(int i = 0; i < SIZE*SIZE; i++) {
			btnArr[i] = new JButton(animal[i]);		// 버튼 한개를 생성한다.
			btnArr[i].setFont(new Font("Gulim", Font.BOLD, 24));
			btnArr[i].addActionListener(handler); 	// 버튼에 리스너를 장착한다.
			add(btnArr[i]);							// 만든 버튼을 프레임에 장착시킨다.
		}
		
		setBounds(500, 100, 600, 600);	// 프레임이 나타날 위치와 크기를 설정한다.(x, y, width, height)
		setVisible(true);				// 만든 프레임을 화면에 보여준다.
	}
	//-----------------------------------------------------------------------------------------------------------
	// class MyEvenetHandler extends WindowAdapter implements ActionListener
	//-----------------------------------------------------------------------------------------------------------
	class MyEventHandler extends WindowAdapter implements ActionListener {
		
		//-----------------------------------------------------------------------------------------------------------
		// 버튼을 눌렀을 경우
		//-----------------------------------------------------------------------------------------------------------
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn =(JButton)e.getSource();	// 눌려진 버튼의 정보를 가져온다.
			
			// 눌려진 버튼에 해당하는 작업을 기술한다.
			for(int i = 0; i < SIZE*SIZE; i++) {
				if((JButton)btn == btnArr[i]) {
					System.out.println("누른 버튼 번호 : " + i);
					btnArr[i].setFont(new Font("Gulim", Font.BOLD+Font.ITALIC, 28));
					btnArr[i].setText(String.valueOf(bingoNum[i]));
					
					// 지금 누른 버튼에 해당하는 btnOX의 값을 true로 변경한다.
					int cnt = 0;	// 2차원 배열의 순서를 1차원으로 설정하는 변수
					for(int x = 0; x < SIZE; x++) {
						for(int y = 0; y < SIZE; y++) {
							// 현재 누른 버튼의 번호와 1차원으로 바꾼 값이 같으면 true로 변경한다.
							if(i == cnt) {
								btnOX[x][y] = true;
							} 
							
							cnt++;
						}
					}
				}	
			}
			btn.setBackground(Color.YELLOW);
			// 빙고가 완성되었는지 검사한다.
			 if(checkBingo() == true) {
				 System.out.println("*** Congraturation!!! Bingo!!! ***");
			 }
			
			// 빙고판의 상태를 콘솔에 출력한다.
			displayOX();	// 버튼의 상태를 2차원 형태의 OX로 보여준다.
			
		} // End - public void actionPerformed(ActionEvent e)
		//-----------------------------------------------------------------------------------------------------------
		// public void windowClosing(WindowEvent e) : 윈도우 우측상단의 x버튼을 누르면 프로그램을 종료시킨다.
		// setDefaultCloseOperation(JFrame.EXIT.ON.CLOSE); 와 같다.
		//-----------------------------------------------------------------------------------------------------------
		@Override
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);	// x버튼이 눌린 창을 안보이게 만든다.
			e.getWindow().dispose();			// 메모리에서 제거한다.
			System.exit(0); 					// 프로그램을 종료한다.
		} // End - public void windowClosing(WindowEvent e)
		
	} // End - class MyEvenetHandler extends WindowAdapter implements ActionListener
	
	//-----------------------------------------------------------------------------------------------------------
	// boolean checkBingo() :  빙고가 완성되어 있는지 검사한다.
	//						   빙고가 완성되면 true를 반환, 아니면 false를 반환
	//-----------------------------------------------------------------------------------------------------------
	boolean checkBingo() {
		this.bingoCount = 0;	// 완성된 라인의 수
		int garoCount   = 0;	// 가로 라인의 수
		int seroCount   = 0;	// 세로 라인의 수
		int crossCount1 = 0;	// 대각선 라인의 수
		int crossCount2 = 0;	// 역대각선 라인의 수	
		
		//btnOX의 값을 검사한다.
		for(int row = 0; row < btnOX.length; row++) {
			for(int col = 0; col < btnOX[row].length; col++) {
				// 가로 검사
				if(btnOX[row][col] == true) {
					garoCount++;
					if(garoCount == SIZE) {	// 같은 줄에 있는 5개가 모두 true이면, 배경색을 바꾼다.
						int begin = row * SIZE;
						int end   = begin + SIZE;
						// 가로로 5개가 모두 true이면, 배경색을 바꾼다.
						for(int n = begin; n < end; n++) {
							btnArr[n].setBackground(Color.GREEN);
						}
					}
				} 
				
				// 세로 검사
				if(btnOX[col][row] == true) {
					seroCount++;
					if(seroCount == SIZE) {
						//for(int n = 0; n < SIZE; n++)
						//btnArr[row + n*SIZE].setBackground(Color.GREEN);
						for(int n = row; n < btnArr.length; n+=5) {
							btnArr[n].setBackground(Color.GREEN);
						}
					}
				}
				// 대각선 검사
				if(btnOX[row][col] == true) {
					if(row == col)
						crossCount1++;
					if(crossCount1 == SIZE) {
						for(int x = 0; x < SIZE; x++) {
							btnArr[x+x*SIZE].setBackground(Color.GREEN);
						}
					}
					
				}
				
				// 역대각선 검사
				if(btnOX[row][col] == true) {
					if(row + col == 4)
						crossCount2++;
					if(crossCount2 == SIZE) {
						for(int x = 0; x < SIZE; x++) {
							btnArr[(SIZE-1)*(x+1)].setBackground(Color.GREEN);	
						}
					}
				}
			}
			// 가로(세로)줄이 5개가 true이면, 가로 한줄 완성
			if(garoCount == SIZE) bingoCount++;
			if(seroCount == SIZE) bingoCount++;
			// 가로(세로) 한줄에 대한 검사가 끝나면 garoCount를 0으로 설정한다.
			garoCount = 0;
			seroCount = 0;
		}
		if(crossCount1 == SIZE) bingoCount++;
		if(crossCount2 == SIZE) bingoCount++;
		return bingoCount == SIZE;
	} // End - boolean checkBingo()
	//-----------------------------------------------------------------------------------------------------------
	// public void displayOX() : 빙고판의 상태를 ○ ● 로 표시한다.
	//-----------------------------------------------------------------------------------------------------------
	public void displayOX() {
		for(int i = 0; i < btnOX.length; i++) {
			for(int j = 0; j < btnOX[i].length; j++) {
				//if(btnOX[i][j] == true) System.out.print("●");
				//else					 System.out.print("○");
				System.out.print(btnOX[i][j] ? "●" : "○");			
			}
			System.out.println();
		}
		System.out.println("현재 맞춘 라인 수 : " + bingoCount);
		System.out.println("--------------------------------------------------------");
	} // End - public void displayOX()
	
	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new Bingo3("빙고게임");

	} // End - public static void main(String[] args)

} // End - public class Bingo3 extends JFrame
