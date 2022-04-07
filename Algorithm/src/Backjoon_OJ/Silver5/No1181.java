package Backjoon_OJ.Silver5;

import java.io.*;
import java.util.*;
import java.util.Comparator;

public class No1181 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int num = Integer.parseInt(br.readLine());
		String words[] = new String[num];
		
		for(int i = 0; i < num; i++) {
			words[i] = br.readLine();
		}
		br.close();
		
		Arrays.sort(words, new Comparator<String>() {
			public int compare(String s1, String s2) {
				if(s1.length() == s2.length()) {
					return s1.compareTo(s2);
				} else {
					return s1.length() - s2.length();
				}
			}
		});
		
		bw.append(words[0] + "\n");
		for(int i = 0; i < words.length; i++) {		
			if(i != 0 && !words[i - 1].equals(words[i])) {				
				bw.append(words[i] + "\n");
			}
		}
		bw.close();
	}
}