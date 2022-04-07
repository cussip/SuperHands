package Backjoon_OJ.Silver3;

import java.io.*;
import java.util.*;

public class No1929 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());

		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());
		
		boolean arr[] = new boolean[end + 1];
		arr[0] = true;
		arr[1] = true;
		
		for(int i = 0; i <= (int)Math.sqrt(end + 1); i++) {
			if(arr[i]) { 
				continue; 
			}
			
			arr[i] = false;		
			for(int j = i + i; j <= end; j += i) {
				if(arr[j]) { 
					continue; 
				}
				arr[j] = true; 		
			}
		}
		
		for(int i = start; i <= end; i++) {
			if(arr[i] == false) {
				System.out.println(i);
			}
		}
	}
}
