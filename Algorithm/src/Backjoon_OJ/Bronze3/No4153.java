package Backjoon_OJ.Bronze3;

import java.io.*;
import java.util.StringTokenizer;

public class No4153 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		while(true) {
			StringTokenizer st = new  StringTokenizer(br.readLine());
			int max = 0;
			int min = 0;
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			int z = Integer.parseInt(st.nextToken());
			if(x == 0 && y == 0 && z == 0) {
				break;
			}
			if(x > y && x > z) {
				max = x * x;
				min = y * y + z * z;
			} else if(y > x && y > z) {
				max = y * y;
				min = x * x + z * z;
			} else {
				max = z * z;
				min = y * y + x * x;
			}
			if(max == min) {
				sb.append("right\n");
			} else {
				sb.append("wrong\n");
			}
		}
		br.close();
		System.out.println(sb);
	}
}
