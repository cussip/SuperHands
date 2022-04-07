package Backjoon_OJ.Silver3;

import java.io.*;
import java.util.Arrays;

public class No2108 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int max = -4000;
		int min = 4000;
		int total = 0;
		
		int arr[] = new int[n];
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			total += arr[i];
			if(arr[i] > max) { max = arr[i]; }
			if(arr[i] < min) { min = arr[i]; }
			
		}
		Arrays.sort(arr);
		
		int cnt = 1;
		int maxCnt = 0;
		int maxNum = arr[0];
		boolean flag = false;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i - 1] == arr[i]) { 
				cnt++; 
				if(cnt > maxCnt) {
					maxCnt = cnt;
					maxNum = arr[i];
					flag = false;
				} else if(cnt == maxCnt && flag == false) {
					maxNum = arr[i];
					flag = true;
				}
			} else {
				cnt = 1;
				if(cnt > maxCnt &&  flag == false) {
					maxCnt = cnt;
					maxNum = arr[i];
					flag = true;
				} 
			}			
		}
			
		sb.append(Math.round((double)total / n) + "\n");
		sb.append(arr[n / 2] + "\n");
		sb.append(maxNum + "\n");
		sb.append(max - min + "\n");
		System.out.println(sb);
	}
}
