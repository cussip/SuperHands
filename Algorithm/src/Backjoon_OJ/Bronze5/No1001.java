package Backjoon_OJ.Bronze5;

import java.io.*;
import java.util.StringTokenizer;

public class No1001 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		br.close();
				
		bw.write(String.valueOf(Integer.parseInt(st.nextToken())
								- Integer.parseInt(st.nextToken())));
		bw.close();
		
	}
}
