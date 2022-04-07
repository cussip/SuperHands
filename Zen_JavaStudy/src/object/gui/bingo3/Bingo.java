package object.gui.bingo3;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

//-----------------------------------------------------------------------------------------------------------
// public class Bingo extends JFrame
//-----------------------------------------------------------------------------------------------------------
public class Bingo extends JFrame {
	
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
	int[] bingoNum = new int[SIZE*SIZE];	// 버튼위치에 숨겨져 있는 숫자를 담을 배열변수
	
	int bingoCount	= 0; // 완성된 라인의 수를 저장할 변수
	private boolean[][] btnOX = new boolean[SIZE][SIZE]; // 빙고판 체크여부를 확인하기 위한 배열 변수
	
	//-----------------------------------------------------------------------------------------------------------
	// 생성자
	//-----------------------------------------------------------------------------------------------------------
	Bingo() {
		this("빙고게임");
	}
	Bingo(String title) {
		super(title);
		setLayout(new GridLayout(SIZE, SIZE));
		
		MyEventHandler handler = new MyEventHandler();
		addWindowListener(handler);
		
		btnArr = new JButton[SIZE*SIZE];	// SIZE*SIZE개의 버튼을 담을 객체배열을 만든다.
		// 버튼 위치에 숨겨져 있는 숫자를 만든다.(1 ~ 25사이의 임의의 정수를 중복되지 않게 만든다.
		// bingoNum[?] = 랜덤한 정수
		
		for(int i = 0; i < SIZE*SIZE; i++) {
			bingoNum[i] = (int)(Math.random() * (SIZE*SIZE) + 1);
			if(i > 0 ) { // 첫번째 방의 값은 비교할 대상이 없으므로 검사에서 제외시킨다.
				for(int j = 0; j < i; j++) {
					if(bingoNum[j] == bingoNum[i]) {
						i--;
					}
				}
			}
		}
		
		// JFrame에 버튼을 추가한다.
		for(int i = 0; i < SIZE*SIZE; i++) {
			btnArr[i]	= new JButton(animal[i]);	// 버튼 한개를 생성한다.
			btnArr[i].setFont(new Font("Gulim", Font.BOLD, 24));
			btnArr[i].addActionListener(handler);	// 버튼에 리스너를 장착한다.
			add(btnArr[i]);							// 만든 버튼을 프레임에 장착시킨다.
		}
		
		
		// 프레임이 나타날 위치와 크기를 설정한다.(x, y, width, height)
		setBounds(500, 100, 600, 600); 	
		setVisible(true);				// 만든 프레임을 화면에 보여준다.
	} // End - Bingo(String title)
	
	//-----------------------------------------------------------------------------------------------------------
	// class MyEventHandler extends WindowAdapter implements ActionListener
	//-----------------------------------------------------------------------------------------------------------
	class MyEventHandler extends WindowAdapter implements ActionListener {

		//-----------------------------------------------------------------------------------------------------------
		// 버튼을 눌렀을 경우
		//-----------------------------------------------------------------------------------------------------------
		@Override
		public void actionPerformed(ActionEvent e) {
			JButton btn = (JButton)e.getSource();	// 눌려진 버튼의 정보를 가져온다.
			
			// 눌려진 버튼에 해당하는 작업을 기술한다.
			for(int i = 0; i < SIZE*SIZE; i++) {
				if((JButton)btn == btnArr[i]) {
					System.out.println("누른 버튼의 번호 : " + i);
					btnArr[i].setFont(new Font("Gulim", Font.BOLD+Font.ITALIC, 28));
					btnArr[i].setText(String.valueOf(bingoNum[i]));
					
					// 지금 누른 버튼에 해당하는 btnOX의 값을 true로 변경시킨다.
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
			} // End - for
			btn.setBackground(Color.YELLOW); // 지금 누른 버튼의 배경색을 변경한다.
			
			// 빙고가 완성되었는지 검사한다.
			if(checkBingo() == true) {
				System.out.println("*** Congraturatio!!! Bingo!!! ***");
			}
			
			// 빙고판의 상태를 콘솔에 출력한다.
			displayOX();	// 버튼의 상태를 2차원 형태의 OX로 보여준다.
			
		} // End - public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub

		//-----------------------------------------------------------------------------------------------------------
		// 윈도우 우측상단의 x버튼을 누르면 프로그램을 종료시킨다.
		// setDefaultyCloseOperation(JFrame.EXIT_ON_CLOSE); 와 같다.
		//-----------------------------------------------------------------------------------------------------------
		@Override
		public void windowClosing(WindowEvent e) {
			e.getWindow().setVisible(false);	// x버튼이 눌린 창을 않보이게 만든다.
			e.getWindow().dispose();			// 메모리에서 제거한다.
			System.exit(0);						// 프로그램을 종료한다.
		}
		
	} // End - class MyEventHandler extends WindowAdapter implements ActionListener
	
	//-----------------------------------------------------------------------------------------------------------
	// 빙고가 완성되어 있는지 검사한다.
	// 빙고가 완성되면 true를 반환하고, 아니면 false를 반환한다.
	//-----------------------------------------------------------------------------------------------------------
	boolean checkBingo() {
		this.bingoCount	= 0;	// 완성된 	라인의 수
		int	garoCount	= 0;	// 가로		라인의 수
		int	seroCount	= 0;	// 세로		라인의 수
		int	crossCount1	= 0;	// 대각선 	라인의 수
		int	crossCount2	= 0;	// 역대각선	라인의 수
		
		// btnOX의 값을 검사한다.
		for(int row = 0; row < btnOX.length; row++) {
			for(int col = 0; col < btnOX[row].length; col++) {
				// 가로 검사
				if(btnOX[row][col] == true) {
					garoCount++;
					if(garoCount == SIZE) { // 같은 줄에 있는 5개가 모두 true이면, 배경색을 바꾼다.
						int	begin	= row   * SIZE;
						int	end		= begin + SIZE;
						// 가로로 5개가 모두 true이면, 배경색을 바꾼다.
						for(int n = begin; n < end; n++) {
							btnArr[n].setBackground(Color.GREEN);
						}
					}
				}
				
				// 세로 검사
				// 가로 검사의 row, col을 반대로 하면 세로 검사가 된다.
				if(btnOX[col][row] == true) {
					seroCount++;
					if(seroCount == SIZE) { // 세로 줄에 있는 5개가 모두 true이면, 배경색을 바꾼다.
						// 5씩 증가시키면서 세로 줄을 색칠한다.
						/*
						for(int n = row; n < btnArr.length; n += 5) {
							btnArr[n].setBackground(Color.GREEN);
						}
						*/
						for(int x = 0; x < SIZE; x++) {
							btnArr[(x*SIZE)+row].setBackground(Color.GREEN);
						}
					}
				}
				
				// 주대각선 검사(좌상단 에서 우하단 방향)
				// row 와 column의 값이 같은 것들을 조사한다.
				// btnOX의 [0][0], [1][1], [2][2], [3][3], [4][4] 가 모두 true이면 주대각선 완성
				if(btnOX[row][col] == true && row == col) {
					crossCount1++;
					if(crossCount1 == SIZE) {
						// 0부터 24까지 6식 증가시키면서 색상을 변경하면 된다.
						// for(int n = 0; n < btnArr.length; n += 6) {
						for(int n = SIZE*SIZE; n < btnArr.length; n += (SIZE+1)) {
							btnArr[n].setBackground(Color.GREEN);
						}
					}
				} // 주대각선 검사 끝
				
				// 역대각선 검사(우상단 에서 좌하단 방향)
				// btxOX[0][4], [1][3], [2][3], [3][1], [4][0] 이 모두 true이면 역대각선 완성
				// 1. row가 0이면 col 이 4, row가 1이면 col 이 3,... 인 것을 검사한다.
				// if((btnOX.length-1) - row) == c && btnOX[row][col] == true)
				// 2. row외 col을 더한 값이 4인 것만 검사하면 된다.
				/*
				if(row + col == 4 && btnOX[row][col] == true) {
					crossCount2++;
					if(crossCount2 == SIZE) {
						//btnArr의 값 중에서 4,5,12,16,20이 true이면 역대각선 완성
						for(int n = 4; n < btnArr.length -1; n += 4) {
							btnArr[n].setBackground(Color.GREEN);
						}
					}
				}
				*/
				if(row + col == SIZE-1 && btnOX[row][col] == true) {
					crossCount2++;
					if(crossCount2 == SIZE) {
						//btnArr의 값 중에서 4,8,12,16,20이 true이면 역대각선 완성
						/*
						// for(int n = 4; n < btnArr.length -1; n += 4) {
						for(int n = SIZE-1; n < btnArr.length -1; n += (SIZE-1)) {
							btnArr[n].setBackground(Color.GREEN);
						}
						*/
						// 4, 8, 12, 16, 20
						// 4의 배수 => ? % 4 == 0
						for(int n = (btnArr.length - SIZE); n > 0; n--) {
							if(n % 4 == 0)
								btnArr[n].setBackground(Color.GREEN);
						}
					}
				}
				
				
			} // End - column
			// 가로줄이 5개가 true이면, 가로 한 줄 완성
			if(garoCount == SIZE)	bingoCount++;
			// 세로줄이 5개가 true이면, 세로 한 줄 완성
			if(seroCount == SIZE)	bingoCount++;	
			
			// crossCount1 와 crossCount2 를 초기화 시키지 않으면 이곳에 기술해도 된다.
			// 초기화 시키지 않으면 crossCount1 가 증가되면서 SIZE와 같아지는 경우는 1번만 존재하므로 
			// if(crossCount1 == SIZE)	bingoCount++;
			
			// 가로 한줄에 대한 검사가 끝나면 garoCount를 0으로 설정한다.
			garoCount = 0;
			// 세로 한줄에 대한 검사가 끝나면 seroCount를 0으로 설정한다.
			seroCount = 0;
			
		} // End - row
		
		// 주대각선과 역대각선은 오직 1개씩만 존재하므로, 검사가 모두 끝난 후에 bingoCount를 증가시킨다.
		if(crossCount1 == SIZE)	bingoCount++;
		if(crossCount2 == SIZE)	bingoCount++;
		

		
		return bingoCount == SIZE;
	} // End - boolean checkBingo()
	//-----------------------------------------------------------------------------------------------------------
	// 빙고판의 상태를 ○ ● 로 표시한다.(한글 ㅁ)
	//-----------------------------------------------------------------------------------------------------------
	public void displayOX() {
		for(int i = 0; i < btnOX.length; i++) {
			for(int j = 0; j < btnOX[i].length; j++) {
				// true, false 대신에 ●, ○ 로 표시하자. 
				// if(btnOX[i][j] == false)	System.out.print("O");
				// else						System.out.print("X");
				System.out.print(btnOX[i][j] ? "●" : "○");
			}
			System.out.println();
		}
		System.out.println("현재 맞춘 라인 수 : " + bingoCount);
		System.out.println("------------------------------------------");
	} // End - public void displayOX()
	
	public static void main(String[] args) {
		new Bingo("빙고게임");

	}

} // End - public class Bingo extends JFrame
