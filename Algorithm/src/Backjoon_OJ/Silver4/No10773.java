package Backjoon_OJ.Silver4;

import java.io.*;
import java.util.Stack;

public class No10773 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int K = Integer.parseInt(br.readLine());
		
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < K; i++) {
			String n = br.readLine();
			
			if(n.equals("0")) {
				st.pop();
			} else {
				st.push(Integer.parseInt(n));
			}
		}
		int result = 0;
		for(int i : st) {
			result += i;
		}
		System.out.println(result);
	}
}
