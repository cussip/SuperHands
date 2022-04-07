package Backjoon_OJ.Bronze1;

import java.io.*;

public class No1157_02 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		int ansCnt = 0;
		String ansStr = null;
		
		StringBuilder sb = new StringBuilder();
		sb.append(br.readLine().toUpperCase());

		while(sb.length() != 0) {	
			
			int cnt = 0;
			String str = sb.substring(sb.length() - 1);

			while(sb.indexOf(str) != -1) {
				sb.deleteCharAt(sb.indexOf(str));
				cnt++;
			}		
			
			if(cnt > ansCnt) {
				ansCnt = cnt;
				ansStr = str;
			} else if(cnt == ansCnt) {
				ansStr = "?";
			}	
		}
		bw.write(ansStr);
	}
}
