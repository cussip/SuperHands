package Backjoon_OJ.Silver5;

import java.io.*;

public class No1436 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		int n = Integer.parseInt(br.readLine());
		br.close();

		int num = 665;
		int cnt = 0;

		while(true) {
			num++;
			int t_num = num;
			int six = 0;
			
			while(t_num != 0) {				
				if(t_num % 10 == 6) {
					six++;
					if(six == 3) {
						cnt++;
						break;
					}
				} else {
					six = 0;
				}
				t_num /= 10;
			}			
			
			if(cnt == n) {
				System.out.println(num);
				break;
			}
		}			
	}
}


