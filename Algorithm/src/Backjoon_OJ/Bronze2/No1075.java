package Backjoon_OJ.Bronze2;

import java.io.*;

public class No1075 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int f = Integer.parseInt(br.readLine());
		
		n = (n / 100) * 100;
		if(n % f != 0) {
			n += f - (n % f);			
		}
		
		String str = String.valueOf(n);
		System.out.println(str.substring(str.length()-2));
//		System.out.printf("%02d", n % 100);
//		메모리와 시간에서 위 방법에 비하여 열위		
	}
}
