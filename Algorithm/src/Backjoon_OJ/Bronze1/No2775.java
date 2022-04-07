package Backjoon_OJ.Bronze1;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No2775 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int n = Integer.parseInt(br.readLine());
				
		for(int i = 0; i < n; i++) {
			int floor = Integer.parseInt(br.readLine());	//층 0층부터
			int room = Integer.parseInt(br.readLine());		//방 1번방부터
			
			int human[][] = new int[floor + 1][room + 1];
			for(int j = 0; j <= floor; j++) {				//j층 탐색
				for(int k = 1; k <= room; k++) {			//k방 탐색, 1번방부터
					if(j == 0) {							//0층일 경우
						human[j][k] = k;					//방의 번호가 인원수와ㅏ 같음
					} else {
						for(int z = 1; z <= k; z++) {			//k방의 인원은 j-1층의 1번부터 k방까지의 인원						
							human[j][k] += human[j-1][z];		//j층 k방의 인원은 j-1층의 k방까지의 인원의 합
						}						
					}
					
				}
			}
			sb.append(human[floor][room] + "\n");
			
		}	
		System.out.println(sb);
/* 
 * 3층 4호의 인원
 * 3층: 1  5  15 35 
 * 2층: 1  4  10 20            
 * 1층: 1  3  6  10       
 * 0층: 1  2  3  4  									
 */				
	}
}
