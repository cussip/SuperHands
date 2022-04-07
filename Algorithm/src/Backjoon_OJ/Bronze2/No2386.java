package Backjoon_OJ.Bronze2;

import java.io.*;
import java.util.ArrayList;

public class No2386 {
	public static void main(String[] args) throws IOException {
		
		ArrayList<String> arr = new ArrayList<>();
		BufferedReader br = new BufferedReader((new InputStreamReader(System.in)));

		while(true) {
			String text = br.readLine().toLowerCase();
			if(text.equals("#")) { 
				for(String s : arr) {
					System.out.println(s);
				}
				break;
			}
			String textArray[] = text.split("");
			String firstCase = textArray[0];	
			
			int count = 0;
			for(int i = 1; i < textArray.length; i++) {
				if(firstCase.equals(textArray[i])) {
					count++;
				}
			}
			arr.add(firstCase + " " + count);
			count = 0;
		}
	}
}
