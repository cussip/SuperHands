package Backjoon_OJ.Bronze2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2231 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int n = Integer.parseInt(br.readLine());	
		boolean chk = false;

		for(int i = 1; i < n; i++) {
			int x = i;
			int ans = x;
			
			while(x != 0) {
				ans += x % 10;
				x /= 10;
			}
			
			if(ans == n) {
				System.out.println(i);
				chk = true;
				break;
			}
		}
		if (chk == false) {
			System.out.println(0);			
		}
	}
}
