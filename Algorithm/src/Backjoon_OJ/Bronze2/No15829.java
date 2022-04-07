package Backjoon_OJ.Bronze2;

import java.io.*;

public class No15829 {
	
	static int r = 31;
	static int M = 1234567891;

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
			
		long sum = 0;		
		for(int i = 0; i < L; i++) {
			int char_ = str.charAt(i) - 96;
			sum = (sum + cal(char_, i)) % M;
		}
		
		System.out.println(sum);
		
	}

	static long cal(int char_, int i) {

		long result = char_;	
		for(int j = 0; j < i; j++) {
			result = (result * r) % M;
		}
		
		return result;
	}
}
