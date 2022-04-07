package Backjoon_OJ.Bronze1;

import java.io.*;
import java.util.StringTokenizer;

public class No1546 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sub = Integer.parseInt(br.readLine());		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		double score[] = new double[sub];
		double maxScore = 0;
		for(int i = 0; i < sub; i++) {
			score[i] = Integer.parseInt(st.nextToken());
			if(score[i] > maxScore) {
				maxScore = score[i];
			}
		}
		
		double totalScore = 0;
		for(int i = 0; i < sub; i++) {
			score[i] = score[i] / maxScore * 100;
			totalScore += score[i];
		}
		System.out.println(totalScore / sub);
	}
}
