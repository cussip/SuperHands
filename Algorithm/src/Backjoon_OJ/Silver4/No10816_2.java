package Backjoon_OJ.Silver4;

import java.io.*;
import java.util.*;

public class No10816_2 {	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());	
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(arr);
			
		int m = Integer.parseInt(br.readLine());	
		st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < m; i++) {
			int quest = Integer.parseInt(st.nextToken());
			sb.append(
					last(arr, quest)
					- start(arr, quest)
					+ " "
					);				
		}
		System.out.println(sb);
	}

	private static int start(int arr[], int quest) {		
		int first = 0;
		int last = arr.length;
		
		while(first != last) {
			int mid = (first + last) / 2;
			
			if(arr[mid] >= quest) {
				last = mid;
			} else {
				first = mid + 1;
			}			
		}
		return first;
	}	
	
	private static int last(int arr[], int quest) {		
		int first = 0;
		int last = arr.length;
		
		while(first != last) {
			int mid = (first + last) / 2;
			
			if(arr[mid] > quest) {
				last = mid;
			} else {
				first = mid + 1;
			}			
		}
		return first;
	}
}


