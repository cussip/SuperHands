package Backjoon_OJ.Bronze2;

import java.io.*;

public class No2577 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int n = 1;		
		for(int i = 0; i < 3; i ++) {
			n *= Integer.parseInt(br.readLine());
		}
	
		int arr[] = new int[10];
		String arrStr[] = String.valueOf(n).split("");
		
		for(int i = 0; i < arrStr.length; i++) {
			arr[Integer.parseInt(arrStr[i])]++;
		}
		
		for(int i = 0; i < 10; i++) {
			bw.write(arr[i] + "\n");
		}
		bw.close();
	}
}
