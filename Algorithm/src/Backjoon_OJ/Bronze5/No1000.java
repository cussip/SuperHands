package Backjoon_OJ.Bronze5;

import java.io.*;
import java.util.StringTokenizer;

public class No1000 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
							new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(
							new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int sum = Integer.parseInt(st.nextToken())
				+ Integer.parseInt(st.nextToken());
		
		bw.write(String.valueOf(sum));
		bw.flush();
		bw.close();			
	}
}
