package Backjoon_OJ.Silver4;

import java.io.*;

public class No9012 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		String arr[] = new String[n];
		
		for(int i = 0; i < n; i++) {
			arr[i] = br.readLine();			
			int search = search(arr[i]);
			if(search == 0 
					&& arr[i].charAt(0) == ('(')
					&& arr[i].charAt(arr[i].length() - 1) == (')')) {
				sb.append("YES\n");
			} else {
				sb.append("NO\n");
			}
		}	
		System.out.println(sb);
	}
	
	static int search(String str) {
		int result = 0;
		for(int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				result++;
			} else {
				result--;
				if(result < 0) { break; }
			}
		}
		return result;
	}
}
