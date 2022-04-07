package Backjoon_OJ.Bronze3;

import java.io.*;
import java.util.StringTokenizer;

public class No10952 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
	
		while(true) {
			String str = br.readLine();
			if(str.equals("0 0")) { break; }
			
			StringTokenizer st = new StringTokenizer(str);
			
			int sum = Integer.parseInt(st.nextToken()) 
					+ Integer.parseInt(st.nextToken());			
			
			bw.write(String.valueOf(sum) + "\n");
		}
		br.close();
		bw.close();
	}
}
