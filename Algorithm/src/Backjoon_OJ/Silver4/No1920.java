package Backjoon_OJ.Silver4;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

public class No1920 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		HashMap<Integer, Integer> hm = new HashMap<>();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			hm.put(Integer.parseInt(st1.nextToken()), 1);
		}
		
		int M = Integer.parseInt(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		for(int i = 0; i < M; i++) {
			int temp = Integer.parseInt(st2.nextToken());
			if(hm.get(temp) != null) {
				sb.append(hm.get(temp) + "\n");
			} else {
				sb.append("0\n");
			}
			
		}
		System.out.println(sb);
	}
}
