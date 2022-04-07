package Backjoon_OJ.Bronze3;

import java.io.*;
import java.util.StringTokenizer;

public class No10250_2 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int repeat = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < repeat; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken()); 
			st.nextToken();
			int n = Integer.parseInt(st.nextToken());	
			
			int temp = n%h == 0 ? n/h : n/h+1;
			String space = temp < 10 ? "0" : "";
			
			sb.append(
						(n%h == 0 ? h : n%h) 
						+ space 
						+ temp 
						+ "\n"
					);					
		}
		br.close();
		System.out.println(sb);	
	}
}
