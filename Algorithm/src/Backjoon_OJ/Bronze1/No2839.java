package Backjoon_OJ.Bronze1;

import java.io.*;

public class No2839 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int sugar;
		int cnt = 0;
		int coef = 0;
		
		while(true) {			
			sugar = n;
			sugar -= (coef * 3);
			
			if(sugar < 0) {
				System.out.println(-1);
				break;
			}
			
			if(sugar % 5 == 0) {
				cnt += coef;
				cnt += sugar / 5;
				System.out.println(cnt);
				break;
			}
			
			coef++;		
		}
	}
}
