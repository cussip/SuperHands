package Backjoon_OJ.Bronze1;

import java.io.*;
import java.util.*;

public class No14843 {
	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int solved = Integer.parseInt(br.readLine());
		double arr[] = new double[4];
		double sum = 0;
		int rank = 0;
		
		for(int i = 0; i < solved; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < 4; j++) {					
				arr[j] = Double.parseDouble(st.nextToken());
			}
			sum += (arr[0] * (1 + (1 / arr[1])) * (1 + (arr[3] / arr[2]))) / 4;
		}	
		
		int pNum = Integer.parseInt(br.readLine());
		double Scores[] = new double[pNum];
		
		for(int i = 0; i < pNum; i++) {
			Scores[i] = Double.parseDouble(br.readLine());
			if(Scores[i] > sum) {
				rank++;
			}
		}
		
		if(rank >= (double)((pNum + 1) * 15 / 100)) {
			System.out.println("The total score of Younghoon is "
								+ String.format("%.2f", sum) + ".");
		} else {
			System.out.println("The total score of Younghoon \"The God\" is "
								+ String.format("%.2f", sum) + ".");
		}		
	}
}