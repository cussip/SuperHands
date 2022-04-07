package Backjoon_OJ.Bronze3;

import java.io.*;
import java.util.StringTokenizer;

public class No10871 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		br.close();
		
		int ns[] = new int[n];
		for(int i = 0; i < n; i++) {
			ns[i] = Integer.parseInt(st.nextToken());
			if(ns[i] < x) {
				bw.append(String.valueOf(ns[i]) + " ");
			}
		}
		bw.close();
	}
}
