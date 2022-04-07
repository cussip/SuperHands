package network;

import java.net.*;
import java.io.*;

//-----------------------------------------------------------------------------------------------------------
// public class NetworkExam03
//-----------------------------------------------------------------------------------------------------------
public class NetworkExam03 {
	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		URL 			url		= null;
		BufferedReader	input	= null;
		String			address	= "https://community.v.daum.net/v/ELzr0KJof2";
		String			line	= "";
		
		try {
			url 	= new URL(address);
			input	= new BufferedReader(new InputStreamReader(url.openStream()));
			
			while((line = input.readLine()) != null) {
				System.out.println(line);
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

} // End - public class NetworkExam03












