package Backjoon_OJ.Bronze3;

import java.io.*;

public class No2742 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));				
		
		int n = Integer.parseInt(br.readLine());	
		
		for(int i = 0; i < n; i++) {
			bw.write(n - i + "\n");
		}
		bw.close();
	}
}
