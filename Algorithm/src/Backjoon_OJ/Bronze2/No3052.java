package Backjoon_OJ.Bronze2;

import java.io.*;
import java.util.HashSet;

public class No3052 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		HashSet<Integer> hs = new HashSet<>();
		
		for(int i = 0; i < 10; i++) {
			int n = Integer.parseInt(br.readLine());
			hs.add(n % 42);
		}
		System.out.println(hs.size());
	}
}
