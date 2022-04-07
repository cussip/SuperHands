package Backjoon_OJ.Bronze3;

import java.io.*;

public class No2439 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 1; i <= n; i++) {
			for(int j = 0; j < n - i; j++) {
				sb.append(" ");
			}
			for(int k = 0; k < i; k++) {
				sb.append("*");
			}		
			sb.append("\n");
		}
		System.out.println(sb);
	}

}
