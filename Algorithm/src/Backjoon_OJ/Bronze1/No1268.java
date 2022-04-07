package Backjoon_OJ.Bronze1;

import java.io.*;
import java.util.StringTokenizer;

public class No1268 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int stu 		= Integer.parseInt(br.readLine());
		int arr[][] 	= new int[stu][5];
		int pointArr[] 	= new int[stu];
		boolean point[] = new boolean[stu];
		
		for(int i = 0; i < stu; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			 for(int j = 0; j < 5; j++) {
				 arr[i][j] = Integer.parseInt(st.nextToken());
			 }	
		}
		
		for(int k = 0; k < stu; k++) {
			for(int j = 0; j < 5; j++) {
				for(int i = 0; i < stu; i++) {
					if(i != k && arr[k][j] == arr[i][j]) {
						point[i] = true;
					}
				}			
			}
			for(int n = 0; n < stu; n++) {
				if(point[n] == true) {
					pointArr[k]++;
					point[n] = false;
				}
			}
		}
		int pre = 0;
		for (int i = 0; i < stu; i++) {
			if(i != 0 && pointArr[pre] < pointArr[i]) {
				pre = i;
			}
		}
		System.out.println(pre + 1);	
	}
}