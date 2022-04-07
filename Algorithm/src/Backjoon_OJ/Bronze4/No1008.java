package Backjoon_OJ.Bronze4;

import java.io.*;
import java.util.StringTokenizer;

public class No1008 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double numA = Integer.parseInt(st.nextToken());
		double numB = Integer.parseInt(st.nextToken());
		
		System.out.println(numA / numB);
	}
}
