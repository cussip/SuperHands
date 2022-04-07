package Backjoon_OJ.Bronze2;

import java.io.*;

public class No10809 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int cnt[] = new int[26];
		
		String str = br.readLine();
		br.close();
		
		for(int i = str.length() - 1; i >= 0; i--) {
			cnt[str.charAt(i) - 97] = i + 1;
		}
		
		for(int i = 0; i < cnt.length; i++) {
			bw.append(cnt[i] - 1 + " ");
		}
		bw.close();
	}
}
