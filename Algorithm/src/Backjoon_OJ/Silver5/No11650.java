package Backjoon_OJ.Silver5;

import java.io.*;
import java.util.*;

public class No11650 {
	public static void main(String[] args)  throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		Sort arr[] = new Sort[n];
		
		for(int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			arr[i] = new Sort(x, y);
		}
		Arrays.sort(arr);
		
		for(int i = 0; i < n; i++) {
			sb.append(arr[i].x + " " + arr[i].y + "\n");
		}
		System.out.println(sb);
	}
}

class Sort implements Comparable {
	int x;
	int y;

	public Sort(int x, int y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public int compareTo(Object o) {
		Sort sort = (Sort)o;
		
		if(x > sort.x || x == sort.x && y > sort.y) {
			return 1;
		} else if (x == sort.x && y == sort.y) {
			return 0;
		} else {
			return -1;
		}	
	}
}
