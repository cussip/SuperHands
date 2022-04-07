package Backjoon_OJ.Silver4;

import java.io.*;
import java.util.Stack;

public class No4949 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();		
		
		while(true) {
			String str = br.readLine();		

			if(str.equals(".")) { 
				break; 
			} else {
				sb.append(solve(str) + "\n");
			}
		}
		br.close();
		System.out.println(sb);
	}
	
	private static String solve(String str) {
		Stack<Character> stack = new Stack<>(); 
		
		for(int i = 0; i < str.length(); i++) {
			switch(str.charAt(i)) {
			case '(':
				stack.add('(');
				break;
			case '[':
				stack.add('[');
				break;
			case ')':
				if(stack.isEmpty() || stack.peek() != ('(')) {
					return "no";
				} else {
					stack.pop();
				}
				break;
			case ']':
				if(stack.isEmpty() || stack.peek() != ('[')) {
					return "no";
				} else {
					stack.pop();
				}
				break;
			}
		}
		if(stack.isEmpty()) {
			return "yes";
		} else {
			return "no";
		}
	}
}

