package Backjoon_OJ.Bronze2;

import java.io.*;

public class No2562 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
				
		int max = 0;
		int maxNum = 0;
		
		for(int i = 0; i < 9; i++) {
			int n = Integer.parseInt(br.readLine());
			if(n > max) {
				max = n;
				maxNum = i + 1;
			}
		}
		br.close();
		
		bw.write(max + "\n" + maxNum);
		bw.close();
	}

}
