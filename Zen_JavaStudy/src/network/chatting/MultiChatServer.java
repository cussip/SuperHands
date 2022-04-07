package network.chatting;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;
//-----------------------------------------------------------------------------------------------------------
// 클라이언트로 부터 전송된 문자열을 받아서 다른 클라이언트들에게 문자열을 보내주는 쓰레드
//-----------------------------------------------------------------------------------------------------------
class EchoThread extends Thread {
	Socket			socket;
	Vector<Socket>	vec;

	//-----------------------------------------------------------------------------------------------------------
	// 생성자
	//-----------------------------------------------------------------------------------------------------------
	public EchoThread(Socket socket, Vector<Socket> vec) {
		this.socket	= socket;
		this.vec	= vec;
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// run() : main()과 같은 역할 
	// 클라이언트에게서 메시지를 받으면, 연결된 다른 클라이언트들에게 메시지를 보내준다.
	//-----------------------------------------------------------------------------------------------------------
	public void run() {
		BufferedReader br = null;
		
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			String str = null;
			
			while(true) {
				// 클라이언트로 부터 문자열 받기
				str = br.readLine();
				
				// 상대가 접속을 끊으면 break;
				if(str == null) {
					vec.remove(socket); // 접속이 끊어진 상대의 정보를 vector목록에서 지운다.
					break;
				}
				// 연결된 소켓들의 정보를 통해서 다른 클라이언트들에게 문자를 보내준다.
				sendMessage(str);
			}
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		} finally {
			// 열려 있는 자원들을 닫는다.
			try {
				if(br		!= null)	br.close();
				if(socket	!= null)	socket.close();
			} catch (IOException ie) {
				System.out.println(ie.getMessage());
			}
		}
	} // End - public void run()
	
	//-----------------------------------------------------------------------------------------------------------
	// 전송받은 메시지를 다른 클라이언트들에게 보내주는 메서드
	//-----------------------------------------------------------------------------------------------------------
	public void sendMessage(String str) {
		try {
			for(Socket socket : vec) { // vec에서 데이터 한 건을 뽑아서 socket에 저장한다.
				// 메시지를 보낸 본인을 제외한 모든 클라이언트(socket)들에게 메시지를 보낸다.
				if(socket != this.socket) {
					PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
					pw.println(str);
					pw.flush();
				}
			}
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		}
	} // End - public void sendMessage(String str)
	
} // End - class EchoThread extends Thread

//-----------------------------------------------------------------------------------------------------------
// public class MultiChatServer
//-----------------------------------------------------------------------------------------------------------
public class MultiChatServer {
	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		ServerSocket	server	= null;
		Socket			socket	= null;
		
		// 클라이언트와 연결된 소켓들을 배열처럼 저장할 벡터객체를 생성한다.(손님명단)
		Vector<Socket> vec	= new Vector<Socket>();

		try {
			server = new ServerSocket(7777);
			
			// 프로그램이 종료될 때까지 클라이언트의 연결 요청을 기다리고,
			// 연결 요청이 들어오면 소켓을 만들어서 클라이언트와 대화할 수 있게 만든다.
			while(true) {
				System.out.println("접속 대기 중.....");
				
				socket = server.accept();
				
				// 클라이언트와 연결된 소켓을 벡터에 담는다.
				vec.add(socket);
				
				// 소켓을 만들어서 클라이언트와 대화할 수 있도록 한다.
				// Thread를 구동시킨다.
				new EchoThread(socket, vec).start();
			}
			
		} catch (IOException ie) {
			System.out.println(ie.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // ENd - public static void main(String[] args)

} // End - public class MultiChatServer


