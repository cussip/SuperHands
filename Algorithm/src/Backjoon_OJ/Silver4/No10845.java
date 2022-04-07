package Backjoon_OJ.Silver4;

import java.io.*;
import java.util.*;

public class No10845 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Deque<Integer> qu = new LinkedList<>();
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			str = str.replace("push ", "");
			
			switch (str) {
				case "pop": {
					if(qu.isEmpty()) {
						sb.append("-1\n");
					} else {
						sb.append(qu.poll() + "\n");						
					}
					break;
				}
				case "size": {
					sb.append(qu.size() + "\n");
					break;
				}
				case "empty": {
					if(qu.isEmpty()) {
						sb.append("1\n");	
					} else {
						sb.append("0\n");						
					}
					break;
				}
				case "front": {
					if(qu.isEmpty()) {
						sb.append("-1\n");
					} else {
						sb.append(qu.peek() + "\n");						
					}
					break;
				}
				case "back": {
					if(qu.isEmpty()) {
						sb.append("-1\n");
					} else {
						sb.append(qu.peekLast() + "\n");						
					}
					break;
				}
				default : {
					qu.add(Integer.parseInt(str));
					break;
				}			
			}
		}	
		System.out.println(sb);
	}
}
