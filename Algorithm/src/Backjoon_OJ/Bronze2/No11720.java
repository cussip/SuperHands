package Backjoon_OJ.Bronze2;

import java.io.*;

public class No11720 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));		
		
		int n = Integer.parseInt(br.readLine());
		String str[] = br.readLine().split("");
		br.close();
		
		int sum = 0;
		for(int i = 0; i < n; i++) {
			sum += Integer.parseInt(str[i]);
		}
		bw.append(String.valueOf(sum));
		bw.close();
	}
}
