package Backjoon_OJ.Silver4;

import java.io.*;
import java.util.StringTokenizer;

public class No10816 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;
		
		int n = Integer.parseInt(br.readLine());	//가지고 있는 숫자 카드의 수
		int arr[] = new int[20000001];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < n; i++) {	//가지고 있는 숫자 카드 내용
			arr[Integer.parseInt(st.nextToken()) + 10000000]++;
		}
		
		int m = Integer.parseInt(br.readLine());	//주어진 숫자 카드의 수

		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < m; i++) {	//주어진 숫자 카드 내용
			
			
			sb.append(
					arr[Integer.parseInt(st.nextToken()) + 10000000] 
					+ " "
					);
		}
		System.out.println(sb);
	}	
}

