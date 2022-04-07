package Backjoon_OJ.Silver5;

import java.io.*;
import java.util.StringTokenizer;

public class No1018 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int ans = 32;
		int cnt = 0;
		
		String wb[] = new String[N];
		char order = 'W';
		
		for(int i = 0; i < N; i++) { wb[i] = br.readLine(); }
		
		for(int x = 0; x < N - 7; x++) {		
			for(int y = 0; y < M - 7; y++) {		
				for(int i = 0 + x; i < 8 + x; i++) {		
					for(int j = 0 + y; j < 8 + y; j++) {
						if(wb[i].charAt(j) != order) { cnt++; }
						if(order == 'W') { order = 'B'; } 
						else { order = 'W'; }
					}					
					if(order == 'W') { order = 'B'; } 
					else { order = 'W'; }				
				}
				if(cnt > 32) { cnt = 64 - cnt; }
				if(cnt < ans) { ans = cnt; }
				cnt = 0;
			}
		}
		System.out.println(ans);
	}
}
