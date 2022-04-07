package object.gui.grimpan;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

//-----------------------------------------------------------------------------------------------------------
// 실제 마우스 이벤트와 버튼 이벤트가 처리되는 클래스
//-----------------------------------------------------------------------------------------------------------
public class MyDrawing extends JFrame {

	//-----------------------------------------------------------------------------------------------------------
	// 멤버 변수
	//-----------------------------------------------------------------------------------------------------------
	JPanel			p1, p2;
	JButton			btnR, btnG, btnB, btnOpen;
	Canvas			can;
	PaintToolFrame	pt;
	
	//-----------------------------------------------------------------------------------------------------------
	// 생성자
	//-----------------------------------------------------------------------------------------------------------
	MyDrawing() {
		
		super("나의 그림판");
		
		pt	= new PaintToolFrame();
		
		p1 	= new JPanel();	add(p1, "North");	// 메인 화면 상단의 버튼 영역
		p2	= new JPanel() {					// 메인 화면의 그림 그리는 영역
			public Insets getInsets() { // 그림 그리기 영역에 여백주기
				return new Insets(40, 10, 10, 10);
			}
		};
		add(p2, "Center");
		p2.setBackground(Color.lightGray);
		
		// 화면 상단에 버튼 만들어 붙이기
		btnR	= new JButton("빨강");			p1.add(btnR);
		btnG	= new JButton("녹색");			p1.add(btnG);
		btnB	= new JButton("파랑");			p1.add(btnB);
		btnOpen	= new JButton("Paint Tool");	p1.add(btnOpen);
		
		// 도화지 역할을 하는 컴포넌트 MyCanvas를 설정한다.
		can = new MyCanvas();
		can.setSize(300, 300);			// 도화지의 크기
		can.setBackground(Color.WHITE);	// 도화지의 배경색 설정
		p2.add(can);					// 그림그리기 영역에 도화지를 부착시킨다.
		
		//-----------------------------------------------------------------------------------------------------------
		// 리스너 부착
		//-----------------------------------------------------------------------------------------------------------
		MyHandler	my	= new MyHandler();
		
		// 캔버스 객체에 마우스 모션 리스너를 부착한다.
		can.addMouseMotionListener(my);	

		// 버튼 들에는 액션 리스너를 부착한다.
		btnR.addActionListener(my);
		btnG.addActionListener(my);
		btnB.addActionListener(my);
		btnOpen.addActionListener(my);
		
		// PaintToolFrame 에도 리스너를 장착한다.
		pt.btnPlus.addActionListener(my);
		pt.btnMinus.addActionListener(my);
		pt.btnClear.addActionListener(my);
		pt.btnAllClear.addActionListener(my);
		pt.btnColor.addActionListener(my);
		pt.btnClose.addActionListener(my);
		
		setLocation(500, 100);
		setSize(500, 500);
		setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	} // End - MyDrawing()
	
	//-----------------------------------------------------------------------------------------------------------
	// 리스너 구현
	//-----------------------------------------------------------------------------------------------------------
	class MyHandler implements MouseMotionListener, ActionListener, MouseListener {

		@Override
		public void mouseDragged(MouseEvent e) {
			System.out.println("mouseDragged");
			setTitle("mouseDragged");
			// 마우스를 드래그란 지점의 x, y 좌표 값을 얻어와서 can의 x, y 좌표 값에 전달한다.
			int xx = e.getX();
			int yy = e.getY();
			setTitle("x:" + xx + ", y:" + yy);
			
			((MyCanvas)can).x = xx;
			((MyCanvas)can).y = yy;
			
			can.repaint();
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void actionPerformed(ActionEvent e) {

			Object 		obj		= e.getSource();
			MyCanvas	can2	= (MyCanvas)can;
			
			if(obj == btnR) {
				can2.cr = Color.RED;
			} else if(obj == btnG) {
				can2.cr = Color.GREEN;
			} else if(obj == btnB) {
				can2.cr = Color.BLUE;
			} else if(obj == btnOpen) {
				// pt.setSize(400, 400);
				pt.pack();	// 크기를 압축해서 보여준다.
				pt.setLocation(getWidth(), 0);	// x값만큼 오른쪽으로 이동해서 보여준다.
				pt.setVisible(true);
			} else if(obj == pt.btnPlus) {
				can2.w	+= 5;
				can2.h	+= 5;
			} else if(obj == pt.btnMinus) {
				// 붓이 사라지지 않게 한다.
				if(can2.w > 3) { // 붓이 사라지지 않게 최소 크기를 설정한다.
					can2.w	-= 5;
					can2.h	-= 5;
				}
			} else if(obj == pt.btnClear) {
				// 드래그한 지점만 부분적으로 지우기
				can2.cr = can.getBackground();
			} else if(obj == pt.btnAllClear) {
				//can2.cr = Color.WHITE;
				Graphics g = can2.getGraphics();
				//g.fillRect(100, 100, 100, 100);
				// g.clearRect(x, y, width, height);
				g.clearRect(0, 0, can.getWidth(), can.getHeight());
			} else if(obj == pt.btnColor) {
				// (Swing에 있음) JColorChooser를 띄워서 선택한 색상으로 그려지도록 한다.
				// nul <== 스크린 중앙에 화면이 나오게 된다.
				Color selectCr = JColorChooser.showDialog(null, "색깔선택", Color.BLUE);
				can2.cr = selectCr;
			} else if(obj == pt.btnClose) {
				// pt만 닫혀지도록 한다.
				// pt.setVisible(false); <== 눈에 보이지 않는 것뿐이다. 
				pt.dispose(); // <== 시스템 자원을 반납해준다.
			}
				
			
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			System.out.println("mousePressed");
			setTitle("mousePressed");
			// 마우스를 드래그란 지점의 x, y 좌표 값을 얻어와서 can의 x, y 좌표 값에 전달한다.
			int xx = e.getX();
			int yy = e.getY();
			setTitle("x:" + xx + ", y:" + yy);
			
			((MyCanvas)can).x = xx;
			((MyCanvas)can).y = yy;
			
			can.repaint();
			
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}

	} // End - class MyHandler MouseMotionListener, ActionListener, MouseListener
	
	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		new MyDrawing();	// 생성자 불러오기
	} // End - public static void main(String[] args)

} // End - public class MyDrawing extends JFrame










