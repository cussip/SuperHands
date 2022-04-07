package Backjoon_OJ.Bronze2;

import java.io.*;
import java.util.StringTokenizer;

public class No2675 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int re = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < re; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int num = Integer.parseInt(st.nextToken());
			String str[] = st.nextToken().split("");
			
			for(int j = 0; j < str.length; j++) {
				for(int k = 0; k < num; k++) {					
					bw.write(str[j]);
				}
			}
			bw.write("\n");
		}
		bw.close();
	}
}
