package Backjoon_OJ.Bronze3;

import java.io.*;

public class No10991 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(
							new InputStreamReader(System.in));
		int num = Integer.parseInt(br.readLine());
		br.close();
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < num; i++) {
			sb.append(" ".repeat(num - i - 1))
			.append("* ".repeat(i + 1))
			.append("\n");
		}
		System.out.println(sb);
	}
}
