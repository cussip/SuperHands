package Backjoon_OJ.Bronze5;

import java.io.*;
import java.util.StringTokenizer;

public class No10869 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));				
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		bw.write((a + b) + "\n" + (a - b) + "\n" + (a * b) + "\n" 
				+ (a / b) + "\n" + (a % b) + "\n");
		bw.close();
	}
}
