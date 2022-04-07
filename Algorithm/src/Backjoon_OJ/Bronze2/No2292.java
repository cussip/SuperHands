package Backjoon_OJ.Bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2292 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int coef = 1;
		int m = 1;

		while(n > m) {
			m = m + (6 * coef);
			coef++;	
		}
		System.out.println(coef);
	}
}