// 메모리 초과

package Backjoon_OJ.Bronze1;

import java.io.*;
import java.util.*;

public class No1157 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		String arr[] = br.readLine().split("");		
		
		Queue<String> qu = new LinkedList<>();
		
		for(int i = 0; i < arr.length; i++) {
			qu.offer(arr[i].toUpperCase());
		}
		
		String 	ans 	= null;
		int 	ansNum 	= 0;
		boolean equal 	= false;
		
		while(qu.isEmpty() == false) {			
			String temp = qu.poll();
			int cnt = 1;
			
			for(int i = 0; i < qu.size(); i++) {			
				if(qu.peek().equals(temp)) {
					cnt++;
					qu.remove();
				} else {
					qu.offer(qu.poll());
				}
			}
			
			if(cnt > ansNum) {
				ansNum = cnt;
				equal = false;
				ans = temp;
			} else if(cnt == ansNum) {
				equal = true;
			}
		}
		
		if(equal == true) {
			System.out.println("?");
		} else {
			System.out.println(ans);
		}
		
	}
}
