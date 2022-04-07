package network;

import java.net.*;
import java.util.*;
//-----------------------------------------------------------------------------------------------------------
// public class NetwrokExam01
//-----------------------------------------------------------------------------------------------------------
public class NetwrokExam01 {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	// InetAddress Class : IP주소를 다루기 위한 클래스
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		InetAddress		ip		= null;
		InetAddress[]	ipArr	= null;
		
		try {
			ip = InetAddress.getByName("www.google.com");
			
			System.out.println("getHostName() : " + ip.getHostName()); 			// 호스트의 이름을 반환한다.
			System.out.println("getHostAddress() : " + ip.getHostAddress());	// 호스트의 ip주소를 반환한다.
			System.out.println("toString() : " + ip.toString());
			
			byte[] ipAddr = ip.getAddress();	// ip주소를 byte배열로 반환한다.
			System.out.println("getAddress() : " + Arrays.toString(ipAddr));
			
			String result = "";
			for(int i = 0; i < ipAddr.length; i++) {
				result += (ipAddr[i] < 0) ? ipAddr[i] + 256 : ipAddr[i];
				result += ".";
			}
			System.out.println("getAddress() + 256 : " + result);
					
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

	} // End - public static void main(String[] args)

} // End - public class NetwrokExam01









