package Backjoon_OJ.Bronze1;

import java.io.*;

public class No1259 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while(true) {
			String s = br.readLine();
			if(s.equals("0")) { break; }
			
			int n = Integer.parseInt(s);
			String t = "";
			
			for(int i = 1; i <= s.length(); i++) {
				t += (n % (int)(Math.pow(10, i))) / (int)Math.pow(10,  i - 1);
				n -= n % (Math.pow(10, i)); 
			}
			
			if(t.equals(s)) {
				bw.append("yes\n");
			} else {
				bw.append("no\n");
			}
		}
		bw.close();
	}
}