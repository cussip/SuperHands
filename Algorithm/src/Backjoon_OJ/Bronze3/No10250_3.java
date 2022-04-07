package Backjoon_OJ.Bronze3;

import java.io.*;
import java.util.StringTokenizer;

public class No10250_3 {
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
			
			int floor = (n%h == 0 ? h : n%h) * 100; 
			int temp = (n%h == 0 ? n/h : n/h+1);
			
			sb.append(floor + temp + "\n");					
		}
		br.close();
		System.out.println(sb);	
	}
}
