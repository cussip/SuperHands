package Backjoon_OJ.Bronze3;

import java.io.*;
import java.util.StringTokenizer;

public class No2884 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int hh = Integer.parseInt(st.nextToken());
		int mm = Integer.parseInt(st.nextToken());
		
		mm -= 45;
		
		if(mm < 0) {
			mm += 60;
			hh -= 1;
			if(hh < 0) {
				hh += 24;
			}	
		}
		System.out.printf("%d %d", hh, mm);	
	}
}
