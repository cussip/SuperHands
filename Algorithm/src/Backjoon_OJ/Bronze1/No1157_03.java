// 메모리 초과

package Backjoon_OJ.Bronze1;

import java.io.*;
import java.util.*;

public class No1157_03 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String str = br.readLine().toUpperCase();
		Queue<Character> qu = new LinkedList<>();
		
		for(int i = 0; i < str.length(); i++) {
			qu.offer(str.charAt(i));
		}
		
		char 	ans 	= ' ';
		int 	ansNum 	= 0;
		
		while(qu.isEmpty() == false) {			
			char temp = qu.peek();
			int cnt = 0;
			
			for(int i = 0; i <= qu.size(); i++) {			
				if(qu.peek().equals(temp)) {
					cnt++;
					qu.remove();
				} else {
					qu.offer(qu.poll());
				}
			}
			if(cnt > ansNum) {
				ansNum = cnt;
				ans = temp;
			} else if(cnt == ansNum) {
				ans = '?';
			}
		}
		System.out.println(ans);
	}
}
