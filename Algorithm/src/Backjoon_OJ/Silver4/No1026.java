package Backjoon_OJ.Silver4;

import java.io.*;
import java.util.StringTokenizer;

public class No1026 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer stA = new StringTokenizer(br.readLine());
		StringTokenizer stB = new StringTokenizer(br.readLine());
		
		int arrA[] = new int[n];
		int arrB[] = new int[n];
		
		for(int i = 0; i < n; i++) {
			arrA[i] = Integer.parseInt(stA.nextToken());
			arrB[i] = Integer.parseInt(stB.nextToken());
		}
				
		for(int i = 0; i < n; i++) {
			for(int j = i; j < n; j++) {
				int temp = 0;
				if(arrB[i] > arrB[j] && arrA[i] > arrA[j] 
						|| arrB[i] < arrB[j] && arrA[i] < arrA[j]) {
					temp = arrA[i];
					arrA[i] = arrA[j];
					arrA[j] = temp;
					j = i - 1;
				}
			}
		}

		int ans = 0;
		for(int i = 0; i < n; i++) {
			ans += arrA[i] * arrB[i];
		}
		System.out.println(ans);
	}
}
