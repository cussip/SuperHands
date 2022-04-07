package Backjoon_OJ.Silver2;

import java.io.*;
import java.util.StringTokenizer;

public class No1012 {
	
	static int M;
	static int N;
	static int K;
	static int[][] cab;
	static boolean[][] check;
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(
							new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();

		int num = Integer.parseInt(br.readLine()); 		//시행 횟수

		for(int k = 0; k < num; k++) {

			int ans = 0;									//필요 지렁이

			StringTokenizer area = new StringTokenizer(br.readLine());
			M = Integer.parseInt(area.nextToken());		//가로길이
			N = Integer.parseInt(area.nextToken());		//세로길이
			K = Integer.parseInt(area.nextToken());		//배추의 수			
			cab = new int[M][N];
			check = new boolean[M][N];
			
			for(int i = 0; i < M; i++) {
				for(int j = 0; j < N; j++) {
					cab[i][j] = -1;
				}
			}
			
			for(int i = 0; i < K; i++) {
				StringTokenizer loca = new StringTokenizer(br.readLine());
				cab		[ Integer.parseInt(loca.nextToken()) ]
						[ Integer.parseInt(loca.nextToken()) ] = 0;
			}
			
			for(int i = 0; i < M; i ++) {
				for(int j = 0; j < N; j++) {
					if(cab[i][j] == 0 && !check[i][j]) {
						dfs(i, j);
						ans++;
					}
				}
			}					
			sb.append(ans + "\n");
		}
		System.out.println(sb);	
	}
	public static void dfs(int x, int y) {
		int dx[] = { -1, 1, 0, 0 };
		int dy[] = { 0, 0, -1, 1 };
		check[x][y] = true;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx >= 0 && ny >= 0 && nx < M && ny < N) {
				if(cab[nx][ny] == 0 && !check[nx][ny]) {
					dfs(nx, ny);
				}
			}
		}
		
	}
	
}
