package Backjoon_OJ.Silver4;

import java.io.*;
import java.util.*;

public class No1740 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		long n = Long.parseLong(br.readLine());
		br.close();
		
		Queue<Long> que = new LinkedList<>();

		while(n > 0) {
			que.add(n % 2);
			n /= 2;
		}
		
		long ans = 0;
		long pow3 = 1;
		
		while(!que.isEmpty()) {
			ans += que.poll() * pow3;
			pow3 *= 3;
		}
		
		bw.append(String.valueOf(ans));
		bw.flush();
		bw.close();
	}	
}
