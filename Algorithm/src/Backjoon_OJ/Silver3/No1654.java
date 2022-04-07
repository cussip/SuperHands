package Backjoon_OJ.Silver3;

import java.io.*;
import java.util.StringTokenizer;

public class No1654 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		int lan[] = new int[K];
		long max = 0;
		long min = 1;
	
		for(int i = 0; i < K; i++) {
			lan[i] = Integer.parseInt(br.readLine());
			if(lan[i] > max) {
				max = lan[i];
			}
		}
		br.close();
		
		while(max >= min) {

			int cnt = 0;
			long mid = (max + min) / 2;
			
			for(int i = 0; i < K; i++) {
				cnt += lan[i] / mid;
			}
			
			if(cnt >= N) {
				min = mid + 1;
			} else if(cnt < N) {
				max = mid - 1;
			}	
		}
		System.out.println(max);
	}
}

