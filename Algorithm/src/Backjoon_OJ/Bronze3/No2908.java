package Backjoon_OJ.Bronze3;

import java.io.*;
import java.util.StringTokenizer;

public class No2908 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
				
		String ch1[] = st.nextToken().split("");
		String ch2[] = st.nextToken().split("");
		String str1 = "";
		String str2 = "";
		boolean ans = true;
		
		for(int i = 0; i < 3; i++) {
			str1 += ch1[2 - i];
			str2 += ch2[2 - i];
		}
				
		for(int i = 0; i < 3; i++) {
			if(Integer.parseInt(ch1[2-i]) < Integer.parseInt(ch2[2-i])) {
				ans = false;
				break;
			} else if(Integer.parseInt(ch1[2-i]) > Integer.parseInt(ch2[2-i])) {
				ans = true;
				break;
			}
		}	

		if(ans == true) {
			System.out.println(str1);
		} else {
			System.out.println(str2);
		}	
	}
}
