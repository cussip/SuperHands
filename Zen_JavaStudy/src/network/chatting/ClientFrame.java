package network.chatting;

import java.awt.*;
import java.awt.event.*;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//-----------------------------------------------------------------------------------------------------------
// class Id : 채팅을 시작하기 전에 닉네임을 입력하는 화면
//-----------------------------------------------------------------------------------------------------------
class Id extends JFrame implements ActionListener {
	
	//-----------------------------------------------------------------------------------------------------------
	// 변수
	//-----------------------------------------------------------------------------------------------------------
	static	JTextField	tf	= new JTextField(8);	// 닉네임 입력란
			JButton		btn	= new JButton("입장");

	WriteThread	wt;
	ClientFrame	cf;
			
	//-----------------------------------------------------------------------------------------------------------
	// 생성자
	//-----------------------------------------------------------------------------------------------------------
	public Id() {}
	public Id(WriteThread wt, ClientFrame cf) {
		super("닉네임 입력");
		this.wt	= wt;
		this.cf	= cf;
		
		setLayout(new FlowLayout());
		add(new JLabel("닉네임"));
		add(tf);	// 입력필드
		add(btn);	// 입장버튼
		
		btn.addActionListener(this);
		
		setBounds(400, 100, 260, 100);	// x좌표, y좌표, 폭, 높이
		setVisible(true);
	} // End - public Id(WriteThread wt, ClientFrame cf)
	
	//-----------------------------------------------------------------------------------------------------------
	// 입장버튼을 누르면
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		// 입장하였다는 메시지를 연결된 클라이언트들에게 보낸다.
		wt.sendMessage();
		
		cf.isFirst	= false;	
		cf.setVisible(true);	// 대화나누기 창을 화면에 나타나게 한다.
		this.dispose();			// 대화나누기 창이 나타나면, 닉네임 입력 창은 사라지게 한다.
		
	} // End - public void actionPerformed(ActionEvent e)
	
	//-----------------------------------------------------------------------------------------------------------
	// 닉네임 알아내기
	//-----------------------------------------------------------------------------------------------------------
	static public String getId() {
		return tf.getText();	// 닉네임 입력 창에서 입력한 내용을(닉네임)을 알려준다.
	} // End - static public String getId()
		
} // End - class Id extends JFrame implements ActionListener

//-----------------------------------------------------------------------------------------------------------
// public class ClientFram : 대화 나누기 창
//-----------------------------------------------------------------------------------------------------------
public class ClientFrame extends JFrame implements ActionListener {

	//-----------------------------------------------------------------------------------------------------------
	// 변수
	//-----------------------------------------------------------------------------------------------------------
	JTextArea	txtA		= new JTextArea();			// 대화를 나눈 내용을 보여주는 부분
	JTextField	txtF		= new JTextField(16);		// 대화를 입력하는 부분
	JButton		btnTransfer	= new JButton("전송");		// 입력한 내용을 전송하는 버튼
	JButton		btnExit		= new JButton("나가기");	// 나가기 버튼
	boolean		isFirst		= true;
	JPanel		p1			= new JPanel();	// 대화입력, 전송버튼, 나가기버튼을 올릴 판넬
	Socket		socket;
	WriteThread	wt;
	
	//-----------------------------------------------------------------------------------------------------------
	// 생성자
	//-----------------------------------------------------------------------------------------------------------
	public ClientFrame(Socket socket) {
		super("대화 나누기");
		this.socket = socket;
		wt	= new WriteThread(this);
		new Id(wt, this);	// 닉네임 입력 창을 생성해서 화면에 보이게 한다.
		
		txtA.setFont(new Font("굴림", Font.ITALIC+Font.BOLD, 24));
		txtA.setBackground(Color.YELLOW);	// new Color(255, 60, 70)
		add("Center", txtA);
		
		// Panel에 입력필드와 버튼(전송, 나가기) 2개를 올리고, Panel을 작업영역의 남쪽에 붙인다.
		p1.add(txtF);
		p1.add(btnTransfer);
		p1.add(btnExit);
		add("South", p1);
		
		// 버튼에 액션리스너를 설정한다.
		btnTransfer.addActionListener(this);
		btnExit.addActionListener(this);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		// 대화 나누기 창의 위치와 폭, 너비를 설정한다.
		setBounds(400, 200, 500, 500);
		setVisible(false);
		
	} // End - public ClientFrame(Socket socket)
	
	//-----------------------------------------------------------------------------------------------------------
	// 전송 버튼 과 나가기 버튼을 눌렀을 경우
	//-----------------------------------------------------------------------------------------------------------
	@Override
	public void actionPerformed(ActionEvent e) {
		// 닉네임을 읽어온다.
		String id = Id.getId();
		
		if(e.getSource() == btnTransfer) {	// 전송 버튼을 누르면
			// 메시지를 입력하지 않은 상태에서 전송 버튼을 누르면 
			if(txtF.getText().equals("")) {
				return;
			}
			// 내가 전송한 메시지는 수신받지 않고 바로 대화내용 창에 붙여 놓는다.
			txtA.append("[" + id + "]" + txtF.getText() + "\n");
			// 서버에 입력한 내용을 전송한다.
			wt.sendMessage();
			// 메시지 전송이 끝나면, 입력 필드를 지운다.
			txtF.setText("");
		} else {	// 나가기 버튼을 누르면
			this.dispose();
		}
		
	} // End - public void actionPerformed(ActionEvent e)

} // End - public class ClientFrame extends JFrame implements ActionListener
















