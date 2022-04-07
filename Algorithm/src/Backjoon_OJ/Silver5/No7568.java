package Backjoon_OJ.Silver5;

import java.io.*;
import java.util.StringTokenizer;

public class No7568 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int n = Integer.parseInt(br.readLine());
		
		int wt[] = new int[n];
		int ht[] = new int[n];
		int rank[] = new int[n];
		StringTokenizer st;
		
		for(int i = 0; i < n; i++) {					//신규 입력. 대조변수가 된다
			st = new StringTokenizer(br.readLine());
			wt[i] = Integer.parseInt(st.nextToken());
			ht[i] = Integer.parseInt(st.nextToken());
			rank[i] = 0;
			for(int j = 0; j < i; j++) {				//기존 입력. 기준변수가 된다.
				if(wt[i] > wt[j] && ht[i] > ht[j]) {	//대조가 기존보다 클 경우
					rank[j]++;							//기존의 크기를 증가 시킨다,
				} else if(wt[i] < wt[j] && ht[i] < ht[j]) {	//대조가 기존보다 작을경우
					rank[i]++;								//대조의 크기를 증가
				} 	
				//이 외의 모든 경우에는 등수를 유지한다.
			}
			//대조변수의 비교가 끝나고 다른 변수를 입력 받는다.
		}
		for(int i : rank) {
			sb.append((i + 1) + "\n");
		}
		System.out.println(sb);
		/** 
		 * 모든 덩치는 1등으로 시작한다. 
		 * 1번은 기준변수다. 최초 1등이다
		 * 2번은 대조 변수이다. 기준 변수와 키와 몸무게를 비교한다.
		 * 키와 몸무게가 전부 기준보다 크면 대조의 등수는 유지, 기준의 등수는 +1
		 * 키와 몸무게 중 하나만 크면 기준과 대조의 등수 유지
		 * 키와 몸무게 둘 다 작으면 대조의 등수 -1
		 * 3번이 대조변수가 되며, 1번부터 순서대로 대조한다.
		 */
	}
}
