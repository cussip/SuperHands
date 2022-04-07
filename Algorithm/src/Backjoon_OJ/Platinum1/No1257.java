package Backjoon_OJ.Platinum1;

import java.io.*;
import java.math.BigInteger;
import java.util.*;

public class No1257 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		BigInteger m = new BigInteger(br.readLine());
		int n = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		Integer arr[] = new Integer[n];		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}		
		Arrays.sort(arr,Collections.reverseOrder());
		
		BigInteger cnt = new BigInteger("0");
		for(int i = 0; i < n; i++) {
			BigInteger temp = new BigInteger("" + arr[i]);
			while(m.compareTo(temp) == 1 || m.compareTo(temp) == 0) {
				cnt = cnt.add(m.divide(temp));	
				m = m.subtract(temp.multiply(m.divide(temp)));
			}
		}
		System.out.println(cnt);
	}
}
