package Backjoon_OJ.Bronze3;

import java.io.*;
import java.util.StringTokenizer;

public class No10250 {
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		int repeat = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < repeat; i++) {
			st = new StringTokenizer(br.readLine());
			int h = Integer.parseInt(st.nextToken()); 
			int w = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());		
		
			loop:
			for(int j = 1; j <= w; j++) {
				for(int k = 1; k <= h; k++) {
					n--;
					if(n == 0 && j < 10) {
						sb.append(k + "0" + j + "\n");
						break loop;
					} else if(n == 0 && j >= 10) {
						sb.append(k + "" + j + "\n");
						break loop;
					}
				}
			}		
		}
		br.close();
		System.out.println(sb);	
	}
}
