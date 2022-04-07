package Backjoon_OJ.Bronze2;

import java.io.*;
import java.util.StringTokenizer;

public class No2798_02 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int max = Integer.parseInt(st.nextToken());
		int result = 0;
		int ans = 0;
		boolean arr[][][] = new boolean[n][n][n];
		
		int card[] = new int[n];
		st = new StringTokenizer(br.readLine());
		
		
		for(int i = 0; i < n; i++) {
			card[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i = 0; i < n; i++) {
			result = card[i];
			
			for(int j = 0; j < n; j++) {
				if(j == i) { continue; }
				result += card[j];
				
				for(int k = 0; k < n; k++) {
					if(k == i || k == j || arr[i][j][k] == true) { continue; }
					result += card[k];
					arr[i][j][k] = true;
					
					if(result > ans && result <= max) {
						ans = result;	
					}
					result -= card[k];
				}
				result -= card[j];
			}
		}
		System.out.println(ans);
	}
}
