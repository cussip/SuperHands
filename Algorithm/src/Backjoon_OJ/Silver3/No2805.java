package Backjoon_OJ.Silver3;

import java.io.*;
import java.util.StringTokenizer;

public class No2805 {
	
	static int tree[];
	static int needH;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));		
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());		
		int treeN = Integer.parseInt(st.nextToken());
		needH = Integer.parseInt(st.nextToken());
		
		int min = 0;
		int max = 0;
		st = new StringTokenizer(br.readLine());
		tree = new int[treeN];
		for(int i = 0; i < treeN; i++) {
			tree[i] = Integer.parseInt(st.nextToken());
			if(tree[i] > max) { max = tree[i]; }
		}
		getH(max, min);				
	}

	private static void getH(int max, int min) {
		int mid = (max + min) / 2;
		int getH = 0;
		
		for(int i = 0; i < tree.length; i++) {
			if(tree[i] > mid) {
				getH += tree[i] - mid;				
			}
		}
		if(getH > needH) {
			getH(max, mid);
		} else if(getH < needH) {
			getH(mid, min);
		} else if(getH == needH) {
			System.out.println(mid);
		} else if(max - min == 1) {
			System.out.println(max);
		}
		//M미터보다 이상의 나무를 가져가는 경우에 대한 계산이 조건이 추가로 필요하다
	}
}








