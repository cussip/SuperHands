package Backjoon_OJ.Silver5;

import java.io.*;
import java.util.StringTokenizer;

public class No1934 {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(
							new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(
							new OutputStreamWriter(System.out));	
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		StringBuilder sb = new StringBuilder();
		
		int q_Num = Integer.parseInt(st.nextToken()); 
//		int arr[] = new int[q_Num];
		
		for(int i = 0; i < q_Num; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			
//			int num3 = Math.max(num1, num2);		
//			for(int j = num3; j <= num1 * num2; j += num3) {
//				if(j % num1 == 0 && j % num2 == 0) {
//					arr[i] = j;
//					break;
//				}
//			}
			sb.append(num1 * num2 / gcd(num1, num2)).append("\n");
			
		}
		bw.write(String.valueOf(sb));
		bw.flush();
		bw.close();
		
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) return a;
		return gcd(b, a % b);
	}
}
