package network;

import java.net.*;
import java.io.*;
//-----------------------------------------------------------------------------------------------------------
// public class NetworkExam04
//-----------------------------------------------------------------------------------------------------------
public class NetworkExam04 {
	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		URL					url	= null;
		InputStream			in	= null;
		FileOutputStream	out	= null;
		
		String	address	= "https://community.v.daum.net/v/ELzr0KJof2";
		int		ch		= 0;

		try {
			url = new URL(address);
			in	= url.openStream();
			out	= new FileOutputStream("c:\\imsi\\readWeb.txt");
			
			while((ch = in.read()) != -1) {
				out.write(ch);
			}
			in.close();
			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	} // End - public static void main(String[] args)

} // End - public class NetworkExam04
















