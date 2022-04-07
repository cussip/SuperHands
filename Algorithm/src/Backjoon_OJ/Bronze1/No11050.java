package Backjoon_OJ.Bronze1;

import java.io.*;
import java.util.StringTokenizer;

public class No11050 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		System.out.println(factorial(n) / (factorial(k) * factorial(n-k)));
	}
	
	static int factorial(int x) {
		if(x <= 1) {
			return 1;
		}
		return x * factorial(x - 1);
	}
}
