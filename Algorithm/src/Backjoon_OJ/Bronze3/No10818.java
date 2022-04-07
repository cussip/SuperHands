package Backjoon_OJ.Bronze3;

import java.io.*;
import java.util.StringTokenizer;

public class No10818 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
	
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int max = Integer.parseInt(st.nextToken());
		int min = max;
		
		for(int i = 1; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());		
			max = Math.max(temp, max);
			min = Math.min(temp, min);
		}
		br.close();
		bw.append(String.valueOf(min) + " " + String.valueOf(max));
		bw.close();
	}
}
