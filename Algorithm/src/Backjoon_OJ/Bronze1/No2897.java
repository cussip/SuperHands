package Backjoon_OJ.Bronze1;

import java.io.*;

public class No2897 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String rowCol = br.readLine();
		String arrRC[] = rowCol.split(" ");
		
		int row = Integer.parseInt(arrRC[0]);
		int col = Integer.parseInt(arrRC[1]);
		
		String array[][] = new String[row][col];
				
		for(int i = 0; i < row; i++) {
			String colInfo = br.readLine();
			String arrCol[] = colInfo.split("");
			for(int j = 0; j < col; j++) {
				array[i][j] = arrCol[j];
			}
		}
		
		int crashCount[] = new int[5];
		int count = 0;
		for(int i = 0; i < row - 1; i++) {
			for(int j = 0; j < col - 1; j++) {
				Loop:
				for(int k = i; k <= i + 1; k++) {
					for(int m = j; m <= j + 1; m++) {
						if(array[k][m].equals("#")) {
							count = 0;
							break Loop;
						} else if(array[k][m].equals("X")) {
							count++;
						}
						if(k == i + 1 && m == j + 1) {
							crashCount[count]++;
						}
					}//End - for m
				}//End - for 
				count = 0;
			}
		}
		for(int i : crashCount) {
			System.out.println(i);
		}
	}
}
