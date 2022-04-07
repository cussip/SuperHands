package Backjoon_OJ.Silver3;

import java.io.*;
import java.util.*;

public class No1874 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		br.close();
		
		int index = 0;		
		Stack<Integer> st = new Stack<>();
		for(int i = 1; i <= n; i++) {
			st.push(i);
			sb.append("+\n");
			while(!st.isEmpty()	&& arr[index] == st.peek()) {
				index++;
				st.pop();
				sb.append("-\n");
			}
		}
		
		if(st.isEmpty()) {
			System.out.print(sb);
		} else {
			System.out.print("NO");
		}
	}
}