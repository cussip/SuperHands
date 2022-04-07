package Backjoon_OJ.Silver4;

import java.io.*;
import java.util.*;

public class No10828 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		Stack<Integer> stack = new Stack<>();
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {	
			String str = br.readLine();
			str = str.replace("push ", "");

			switch (str) {
				case "pop": {
					if(stack.isEmpty()) {
						sb.append("-1\n");
					} else {
						sb.append(stack.pop() + "\n");						
					}
					break;
				}
				case "size": {
					sb.append(stack.size() + "\n");
					break;
				}
				case "empty": {
					if(stack.isEmpty()) {
						sb.append("1\n");	
					} else {
						sb.append("0\n");						
					}
					break;
				}
				case "top": {
					if(stack.isEmpty()) {
						sb.append("-1\n");
					} else {
						sb.append(stack.peek() + "\n");						
					}
					break;
				}
				default : {
					stack.push(Integer.parseInt(str));
					break;
				}
			}
		}
		System.out.println(sb);
	}
}
