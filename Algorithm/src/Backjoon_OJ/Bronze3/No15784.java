package Backjoon_OJ.Bronze3;

import java.io.*;
import java.util.StringTokenizer;

public class No15784 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader( 
							new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int len = Integer.parseInt(st1.nextToken());
		int area[][] = new int[len][len];
		int x = Integer.parseInt(st1.nextToken()) - 1;
		int y = Integer.parseInt(st1.nextToken()) - 1;
		boolean angry = false;
		
		for(int i = 0; i < len; i++) {
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			for(int j = 0; j < len; j++) {
				area[i][j] = Integer.parseInt(st2.nextToken());
			}
		}
		for(int i = 0; i < len; i++) {
			if(area[i][y] > area[x][y]) {
				angry = true;
			}
		}
		for(int i = 0; i < len; i++) {
			if(area[x][i] > area[x][y]) {
				angry = true;
			}
		}
		if(angry == true) {
			System.out.println("ANGRY");
		} else if(angry == false) {
			System.out.println("HAPPY");
		}
		
	}
}
