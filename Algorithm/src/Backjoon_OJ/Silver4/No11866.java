package Backjoon_OJ.Silver4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class No11866 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		Queue<Integer> qu = new LinkedList<>();
		
		for(int i = 1; i <= n; i++) {
			qu.add(i);
		}
		
		while(qu.size() != 0) {
			for(int i = 0; i < k - 1; i++) {
				qu.add(qu.poll());
			}
			sb.append(qu.poll());
			if(!qu.isEmpty()) { sb.append(", "); }
		}
		
		System.out.println("<" + sb + ">");
	}
}
