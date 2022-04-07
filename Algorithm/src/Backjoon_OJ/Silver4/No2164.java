package Backjoon_OJ.Silver4;

import java.io.*;
import java.util.*;

public class No2164 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		br.close();
		
		Queue<Integer> qu = new LinkedList<>();
		for(int i = 1; i <= n; i++) {
			qu.add(i);
		}
		while(qu.size() > 1) {
			qu.remove();
			qu.add(qu.poll());
		}
		System.out.println(qu.peek());
	}
}
