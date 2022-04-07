package Backjoon_OJ.Bronze5;

import java.io.*;
import java.util.StringTokenizer;

public class No3046 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int r1 = Integer.parseInt(st.nextToken());
		int avg = Integer.parseInt(st.nextToken());
	
		bw.write(String.valueOf(avg * 2 - r1));
		bw.flush();
		bw.close();	
	}
}
