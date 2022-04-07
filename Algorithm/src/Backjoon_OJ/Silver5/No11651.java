package Backjoon_OJ.Silver5;

import java.io.*;
import java.util.*;

public class No11651 {
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		SortY arr[] = new SortY[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new SortY(x, y);
		}
		Arrays.sort(arr);
		
		for(int i = 0; i < n; i++) {
			sb.append(arr[i].x + " " + arr[i].y + "\n");
		}
		System.out.println(sb);
	}
}

class SortY implements Comparable {
	int x;
	int y;

	public SortY(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Object o) {
		SortY sortY = (SortY)o;
		
		if(y > sortY.y || y == sortY.y && x > sortY.x) {
			return 1;
		} else if (x == sortY.x && y == sortY.y) {
			return 0;
		} else {
			return -1;
		}	
	}
}
