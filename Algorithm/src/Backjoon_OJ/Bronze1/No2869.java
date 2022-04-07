package Backjoon_OJ.Bronze1;

import java.io.*;
import java.util.StringTokenizer;

public class No2869 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int climb = Integer.parseInt(st.nextToken());
		int slip = Integer.parseInt(st.nextToken());
		int height = Integer.parseInt(st.nextToken());
		
		int day = (height - climb) / (climb - slip);
		if((height- climb) % (climb - slip) > 0) {
			day++;
		} 
		
		System.out.println(day + 1);
	}
}
