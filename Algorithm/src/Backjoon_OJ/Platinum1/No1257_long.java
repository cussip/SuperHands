package Backjoon_OJ.Platinum1;

import java.io.*;
import java.util.*;

public class No1257_long {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long m = Long.parseLong(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Integer arr[] = new Integer[n];		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}		
		Arrays.sort(arr,Collections.reverseOrder());
		
		long cnt = 0;
		for(int i = 0; i < n; i++) {
			while(m >= arr[i]) {
				cnt += m / arr[i];
				m -= arr[i] * (m / arr[i]);
			}
		}
		System.out.println(cnt);
	}
}
