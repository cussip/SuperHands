package Backjoon_OJ.Silver4;

import java.io.*;
import java.util.StringTokenizer;

public class No1002 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( 
							new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int cnt = Integer.parseInt(br.readLine());
		
		int d[] = new int[6];
		
		for(int k = 0; k < cnt; k++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i = 0; i < d.length; i++) {
				d[i] = Integer.parseInt(st.nextToken());;
			}
			
			double r3 = Math.sqrt(Math.pow((d[3] - d[0]), 2) 
								+ Math.pow((d[4] - d[1]), 2));
			
			if(r3 > d[2] + d[5] 
					|| r3 < Math.abs(d[2] - d[5])) {
				sb.append(0 + "\n");	
				
			} else if(r3 == d[2] + d[5]
					|| (r3 == Math.abs(d[2] - d[5]) && r3 != 0)) {
				sb.append(1 + "\n");	
				
			} else if(r3 < d[2] + d[5]
					&& r3 > Math.abs(d[2] - d[5])) {
				sb.append(2 + "\n");	
				
			} else if(r3 == 0 && d[2] == d[5]) {
				sb.append(-1 + "\n");
			}			
		}
		br.close();
		System.out.println(sb);
	}
}
