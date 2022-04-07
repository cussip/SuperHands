package Backjoon_OJ.Bronze2;

import java.io.*;
import java.util.StringTokenizer;

public class No2864 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(
							new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(
							new OutputStreamWriter(System.out));
		
		String origin  = br.readLine(); 
		
		StringTokenizer st5 = new StringTokenizer(origin.replace("6", "5"));	
		int sum5 = Integer.parseInt(st5.nextToken()) + Integer.parseInt(st5.nextToken());
		
		StringTokenizer st6 = new StringTokenizer(origin.replace("5", "6"));	
		int sum6 = Integer.parseInt(st6.nextToken()) + Integer.parseInt(st6.nextToken());
				
		bw.write(String.valueOf(sum5) + " " + String.valueOf(sum6));
		bw.flush();
		bw.close();
	}
}
