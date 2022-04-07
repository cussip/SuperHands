package Backjoon_OJ.Silver4;

import java.io.*;
import java.util.*;

public class No10866 {

	static Deque<Integer> qu = new LinkedList<>();

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < n; i++) {
			String str = br.readLine();
			
			if(str.contains("push_front")) {
				pushFront(str);
			} else if(str.contains("push_back")) {
				pushBack(str);
			} else {				
				switch (str) {
					case "pop_front": {
						if(qu.isEmpty()) {
							sb.append("-1\n");
						} else {
							sb.append(qu.pollLast() + "\n");						
						}
						break;
					}
					case "pop_back": {
						if(qu.isEmpty()) {
							sb.append("-1\n");
						} else {
							sb.append(qu.pollFirst() + "\n");						
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
							sb.append(qu.peekLast() + "\n");						
						}
						break;
					}
					case "back": {
						if(qu.isEmpty()) {
							sb.append("-1\n");
						} else {
							sb.append(qu.peekFirst() + "\n");						
						}
						break;
					}
				}
			}		
		}	
		System.out.println(sb);
	}

	static void pushBack(String str) {
		str = str.replace("push_back ", "");
		qu.addFirst(Integer.parseInt(str));
	}

	static void pushFront(String str) {
		str = str.replace("push_front ", "");	
		qu.addLast(Integer.parseInt(str));
	}	
}
