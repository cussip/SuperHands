package Backjoon_OJ.Bronze3;

import java.io.*;
import java.util.StringTokenizer;

public class No10951 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		StringTokenizer st;
		String str;
		while((str = br.readLine()) != null) {
			st = new StringTokenizer(str);
			int sum = Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
			bw.append(String.valueOf(sum) + "\n");
		}		
		br.close();
		bw.close();			
	}
}
