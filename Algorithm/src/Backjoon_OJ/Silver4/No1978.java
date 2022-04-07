package Backjoon_OJ.Silver4;

import java.io.*;
import java.util.StringTokenizer;

public class No1978 {
	
	static int ans;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		ans = n;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i = 0; i < n; i++) {
			int temp = Integer.parseInt(st.nextToken());
			primeNumber(temp);
		}
		System.out.println(ans);
	}
	
	public static void primeNumber(int x) {
		if(x == 1) { ans--; }

		for(int i = 2; i < Math.sqrt(x + 1); i++) {		//2부터 sqrt(x+1)까지의 값으로 x를 나누어본다
			if(x != 2 && x % i == 0) {	//나머지가 0이면 소수가 아니므로 
				ans--;			//주어진 ans개의 숫자 중 하나인 x 소수가 아니므로 -1 한다
				break;			//for문을 빠져나간다	
			}
		}
	}
}
