package Backjoon_OJ.Silver5;

import java.io.*;
import java.util.*;

public class No2751_02 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		boolean chk[] = new boolean[2000001];
		
		for(int i = 0; i < n; i++) {
			chk[Integer.parseInt(br.readLine()) + 1000000] = true;
		}
		br.close();
	
		for(int i = 0; i < chk.length; i++) {
			if(chk[i] == true) {
				sb.append((i - 1000000) + "\n");				
			}
		}
		System.out.println(sb);		
	}
}
