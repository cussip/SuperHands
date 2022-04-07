package Backjoon_OJ.Silver5;

import java.io.*;

public class No11653 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
							new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(
							new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());			
		
		int d_Num = 2;
		do {
			if(num == 1) { break; }
			if(num < d_Num * 2) {
				sb.append(num);
				break;
			}
			if(num % d_Num == 0) {
				sb.append(d_Num + "\n");
				num = num / d_Num;
				d_Num = 1;
			}
			if(d_Num == num / 2) {
				sb.append(num);
			}		
			d_Num++;
		}
		while(d_Num <= num / 2);
	
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
	}
}
