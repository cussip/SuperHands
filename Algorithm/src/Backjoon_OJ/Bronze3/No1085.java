package Backjoon_OJ.Bronze3;

import java.io.*;
import java.util.StringTokenizer;

public class No1085 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		
		int distance = x;
		
		if (distance > w - x) {
			distance = w - x;
		} 
		if (distance > y) {
			distance = y;
		}
		if (distance > h - y) {
			distance = h - y;
		}
		
		bw.write(String.valueOf(distance));
		bw.flush();
		bw.close();
		
	}
}
