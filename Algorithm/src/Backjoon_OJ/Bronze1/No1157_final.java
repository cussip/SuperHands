package Backjoon_OJ.Bronze1;

import java.io.*;

public class No1157_final {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine().toUpperCase();
		
		int cnt[] = new int[26];		
		for(int i = 0; i < str.length(); i++) {
			cnt[str.charAt(i) - 65]++;	
		}
		
		int ansCnt = 0;
		char ans = ' ';

		for(int i = 0; i < cnt.length; i++) {
			if(cnt[i] > ansCnt) {
				ansCnt = cnt[i];
				ans = (char) (i + 65);
			} else if(cnt[i] == ansCnt) {
				ans = '?';
			}
		}		
		System.out.println(ans);
	}

}
