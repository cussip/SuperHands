package Backjoon_OJ.Silver5;

import java.io.*;
import java.util.*;

public class No10814 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		String arr[][] = new String[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}	
		br.close();
		
		Arrays.sort(arr, new Comparator<String[]>() {
			public int compare(String[] s1, String[] s2) {
				return Integer.parseInt(s1[0]) - Integer.parseInt(s2[0]);
//				return s1[0].compareTo(s2[0]);
			}
		});
		
		
		for(int i = 0; i < N; i++) {
			bw.append(arr[i][0] + " ");
			bw.append(arr[i][1] + "\n");
		}
		bw.close();	
	}
}
