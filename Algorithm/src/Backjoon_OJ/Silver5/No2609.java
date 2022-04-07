package Backjoon_OJ.Silver5;

import java.io.*;
import java.util.*;

public class No2609 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int n1 = Integer.parseInt(st.nextToken());
		int n2 = Integer.parseInt(st.nextToken());
		
		int gcd_ = gcd(n1, n2);
		
		sb.append(gcd_ + "\n");
		sb.append(n1 * n2 / (gcd(n1, n2)));
		
		System.out.println(sb);
		/*
		 * 최대공약수
		 * a, b의 최대공약수 = b, a%b의 최대공약수
		 * 뒷 자리가 0이되는 시점의 앞 자리가 최대공약수 
		 * 
		 * 최소공배수
		 * a * b / 최대공약수
		 */ 
	}
	public static int gcd(int a, int b) {
		if(b != 0) {
			return gcd(b, a % b);
		} 
		return a;
	}
}
