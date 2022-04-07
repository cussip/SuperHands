package Backjoon_OJ.Silver3;

import java.io.*;
import java.util.StringTokenizer;

public class No2805_2 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());		
		int treeN = Integer.parseInt(st.nextToken());
		int needH = Integer.parseInt(st.nextToken());
		
		int min = 0;
		int max = 0;
		st = new StringTokenizer(br.readLine());
		
		int tree[] = new int[treeN];
		for(int i = 0; i < treeN; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(tree[i] > max) { max = tree[i]; }
		}
		br.close();
		
		while(max > min) {
			int mid = (max + min) / 2;
			long getH = 0;
			for(int treeH : tree) {
				if(treeH > mid) {
					getH += (treeH - mid);					
				}
			}
			if(getH < needH) {
				max = mid;
			} else {
				min = mid + 1;
			}
		}
		System.out.println(min - 1);
	}
}








