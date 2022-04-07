package Backjoon_OJ.Bronze2;

import java.io.*;

public class No8958 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
	
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String ox = br.readLine();
			int cnt = 0;
			int sum = 0;
			int score = 0;
			for(int j = 0; j < ox.length(); j++) {
				if (ox.charAt(j) == 'O') {
					cnt++;
					sum += cnt;
				} else {
					score += sum;
					cnt = 0;
					sum = 0;
				}
			}
			score += sum;
			bw.write(String.valueOf(score + "\n"));
		}
		br.close();
		bw.close();		
	}
}