package Backjoon_OJ.Bronze5;

import java.io.*;
import java.util.StringTokenizer;

public class No15964 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(  
							new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long a = Integer.parseInt(st.nextToken());
		long b = Integer.parseInt(st.nextToken());
		
		System.out.println((a + b) * (a - b));
	}
}
