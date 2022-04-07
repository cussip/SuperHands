package network.chatting;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

//-----------------------------------------------------------------------------------------------------------
// 키보드로 전송할 문자열을 입력받아서 서버로 전송하는 클래스
//-----------------------------------------------------------------------------------------------------------
class WriteThread {
	//-----------------------------------------------------------------------------------------------------------
	// 변수
	//-----------------------------------------------------------------------------------------------------------
	Socket		socket;
	ClientFrame	cf;
	String		str;
	String		id;
	
	//-----------------------------------------------------------------------------------------------------------
	// 생성자
	//-----------------------------------------------------------------------------------------------------------
	public WriteThread(ClientFrame cf) {
		this.cf		= cf;
		this.socket	= cf.socket;
	} // End - public WriteThread(ClientFrame cf)
	
	//-----------------------------------------------------------------------------------------------------------
	// id(닉네임)을 구하는 메서드
	//-----------------------------------------------------------------------------------------------------------
	public void getId() {
		id = Id.getId();
	} // End - public void getId()
	
	//-----------------------------------------------------------------------------------------------------------
	// 다른 접속자들에게 메시지를 보내는 메서드
	//-----------------------------------------------------------------------------------------------------------
	public void sendMessage() {
		// 키보드로 부터 입력된 내용을 읽어오기 위한 스트림 객체를 생성한다.
		BufferedReader	br	= new BufferedReader(new InputStreamReader(System.in));
		PrintWriter		pw	= null;
		
		try {
			// 서버로 문자열을 전송하기 위한 스트림 객체를 생성한다.
			pw = new PrintWriter(socket.getOutputStream(), true);
			
			// 첫번째로 전송하는 내용은 상대방에게 id와 ip주소를 전송한다.
			if(cf.isFirst == true) {
				InetAddress	iaddr	= socket.getLocalAddress();
				String		ip		= iaddr.getHostAddress();
				getId();
				str	= "[" + id + "] 님 로그인 (" + ip + ")";
			} else {
				str	= "[" + id + "]" + cf.txtF.getText();
			}
			// 입력한 문자열을 서버로 보내기
			pw.println(str);
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		} finally {
			try {
				if(br != null) 	br.close();
			} catch (IOException ie) {
				System.out.println(ie.getMessage());
			}
		}
		
	} // End - public void sendMessage()
	
} // End - class WriteThread

//-----------------------------------------------------------------------------------------------------------
// 서버가 보내온 문자열을 받는 쓰레드
//-----------------------------------------------------------------------------------------------------------
class ReadThread extends Thread {
	Socket		socket;
	ClientFrame	cf;
	
	//-----------------------------------------------------------------------------------------------------------
	// 생성자
	//-----------------------------------------------------------------------------------------------------------
	public ReadThread(Socket socket, ClientFrame cf) {
		this.cf		= cf;
		this.socket	= socket;
	} // End - public ReadThread(Socket socket, ClientFrame cf)

	//-----------------------------------------------------------------------------------------------------------
	// run()
	// 서버로 부터 전송되는 메시지를 수신하고, 수신된 내용을 대화내용 창에 보여준다.
	//-----------------------------------------------------------------------------------------------------------
	public void run() {
		BufferedReader br = null;
		
		try {
			// 서버로 부터 전송되어온 문자열을 읽어오기 위한 스트림객체를 생성한다.
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			
			while(true) {
				// 소켓으로 부터 문자열을 읽어들인다.
				String str = br.readLine();
				if(str == null) {	// 접속이 끊어 졌다면
					System.out.println("접속이 끊겼습니다.");
					break;
				}
				// 수신된 메시지를 대화 내용 창에 보여준다.
				cf.txtA.append(str + "\n");
			}
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		} finally {
			try {
				if(br		!= null)	br.close();
				if(socket	!= null)	socket.close();
			} catch (IOException ie) {
				System.out.println(ie.getMessage());
			}
		}
		
	} // End - public void run()
	

	
} // End - class ReadThread extends Thread

//-----------------------------------------------------------------------------------------------------------
// public class MultiChatClient
//-----------------------------------------------------------------------------------------------------------
public class MultiChatClient {
	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		
		Socket		socket	= null;
		ClientFrame	cf;
		
		try {
			// new Socket("연결할 서버의 ip주소", 포트번호);
			// 211.238.140.13 == 127.0.0.1 == localhost
			socket = new Socket("211.238.140.13", 7777);
			System.out.println("채팅서버에 연결이 되었습니다.");
			
			// 대화 나누기 창을 띄운다.
			// ==> 대화 나누기 창은 닉네임 입력 창을 생성하고 보여주고, 대화 나누기 창은 화면에서 숨겨버린다.
			cf = new ClientFrame(socket);
			
			// 다른 클라이언트가 보내주는 메시지를 수신하기 위한 쓰레드를 구동시킨다.
			new ReadThread(socket, cf).start();
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
		
	} // ENd - public static void main(String[] args)

} // End - public class MultiChatClient











