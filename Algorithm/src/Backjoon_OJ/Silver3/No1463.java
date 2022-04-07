package Backjoon_OJ.Silver3;

import java.io.*;

public class No1463 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(
							new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		br.close();
		
		int cnt[] = new int[num + 1];
		cnt[0] = 0;
		cnt[1] = 0;
		
		for(int i = 2; i <= num; i++) {
			cnt[i] = cnt[i - 1] + 1;
			if(i % 3 == 0) {
				cnt[i] = Math.min(cnt[i], cnt[i / 3] + 1);				
			}
			if(i % 2 == 0) {
				cnt[i] = Math.min(cnt[i], cnt[i / 2] + 1);
			}
		}
		
		System.out.println(cnt[num]);
	}
}
