package Backjoon_OJ.Silver5;

import java.io.*;
import java.util.*;

public class No2751 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> list = new ArrayList<>();
//		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			list.add(Integer.parseInt(br.readLine()));
		}
		br.close();
//		Arrays.sort(arr);
		
//		for(int i = 1; i < n; i++) {
//			if(arr[i - 1] > arr[i]) {
//				arr[i - 1] += arr[i];
//				arr[i] = arr[i - 1] - arr[i];
//				arr[i - 1] -= arr[i];
//				i = 0;
//			}
//		}	시간초과
		
		Collections.sort(list);
		
		for(int i : list) {			
			sb.append(i + "\n");
		}
		System.out.println(sb);
		
	}
}
