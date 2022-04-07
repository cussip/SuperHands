package Backjoon_OJ.Silver2;

import java.io.*;
import java.util.StringTokenizer;

public class No18111 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int y = Integer.parseInt(st.nextToken());
		int x = Integer.parseInt(st.nextToken());
		int inven = Integer.parseInt(st.nextToken());	
		int arr[][] = new int[x][y];	
		 
		int floor = 256;
		for(int i = 0; i < y; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < x; j++) {
				arr[j][i] = Integer.parseInt(st.nextToken());	
				if(arr[j][i] < floor) { floor = arr[j][i]; }
			}
		}
					
		int ansFloor = 0;
		int ansSec = 0;
		int block = 0;
		
		while(true) {			
			int sec = 0;			
			block = inven;			
			for(int i = 0; i < y; i++) {
				for(int j = 0; j < x; j++) {
					if(arr[j][i] > floor) {
						sec += (arr[j][i] - floor) * 2;
						block += arr[j][i] - floor;
					} else if(arr[j][i] < floor) {
						sec += floor - arr[j][i];
						block -= floor - arr[j][i];
					}
				}
			}
			
			if(block < 0) { break; }
										
			if(sec <= ansSec || ansSec == 0) { 
				ansSec = sec;
				ansFloor = floor;
				floor++;
			} else if(sec > ansSec) {	
				break;
			}
		}
		sb.append(ansSec + " " + ansFloor);
		System.out.println(sb);
	}
}




