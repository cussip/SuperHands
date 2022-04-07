package Backjoon_OJ.Silver3;

import java.io.*;
import java.util.*;

public class No1966 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int totN = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < totN; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st1.nextToken());		// 탐색할 변수의 숫자
			int x = Integer.parseInt(st1.nextToken());		// 출력 순서를 확인하고 싶은 변수의 순번
			int xVal = 0;	// x의 중요도
			
			Queue<Integer> qu = new LinkedList<>();
			for(int j = 0; j < n; j++) {	// 0부터 n까지 총 n개의 변수를 qu에 저장
				int tmp = Integer.parseInt(st2.nextToken());
				qu.add(tmp);	// qu에 변수를 순서대로 저장
				if(j == x) {	// j가 x번째를 탐색하면 x
					xVal = tmp;
				}
			}
			
			int cnt = 0;		//출력 횟수를 저장할 변수
			for(int val = 9; val >= xVal; val--) {	//중요도가 x의 중요도와 같을때까지 조회	
				for(int j = 0; j < qu.size(); j++) {	//qu의 크기만큼 한바퀴 돌면서 조회					
					if(qu.peek() == val) {					//qu에서 peek한 변수가 val과 같은 값이면
						qu.remove();						//qu에서 remove							
						cnt++;								//+출력 1회 
						if(x == 0) {						//x가 0이면 목표하던 숫자가 출력된 상황이므로 
							sb.append(cnt + "\n"); 			//출력횟수를 저장하고							
							break;							//반복문을 종료한다.
						} else {							//x가 0이 아니었을 경우
							x--;							//qu가 하나 줄어들었으므로 x의 위치도 한 칸 감소		
							j = -1;							//한 개가 출력된 시점부터 다시 한바퀴를 조회하도록 지정
						}
					} else if(qu.peek() < val) {			//qu에서 peek한 변수가 val보다 작으면
						qu.add(qu.poll());					//qu에서 poll한 변수를 qu의 뒤로 다시 입력
						if(x == 0) {
							x = qu.size() - 1;				//x가 0일경우 전체 크기 -1로 재설정(맨뒤로 돌아간 상태)
						} else {							//x가 0이 아닐 경우
							x--;							//qu가 앞으로 한 칸 씩 당겨졌으므로 x도 한 칸 감소						
						}
					}			
				}
			}
		}
		System.out.println(sb);
	}
}
