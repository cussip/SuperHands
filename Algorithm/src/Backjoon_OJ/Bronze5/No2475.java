package Backjoon_OJ.Bronze5;

import java.io.*;
import java.util.StringTokenizer;

public class No2475 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int ans = 0;
		for(int i = 0; i < 5; i++) {
			int temp = Integer.parseInt(st.nextToken());
			ans += (int) Math.pow(temp, 2);
		}
		br.close();
		bw.write(String.valueOf(ans % 10));
		bw.close();
	}
}
