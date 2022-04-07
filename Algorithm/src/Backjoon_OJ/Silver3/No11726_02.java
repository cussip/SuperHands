package Backjoon_OJ.Silver3;

import java.io.*;

public class No11726_02 {
	
	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader( 
							new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		long n1 = 0;
		long n2 = 0;
		long ans = 1;
		
		for(int i = 0; i < num; i++) {
			n1 = n2 % 10007;
			n2 = ans % 10007;
			ans = n1 + n2;
			
		}
		System.out.println(ans % 10007);
			
	}
}
