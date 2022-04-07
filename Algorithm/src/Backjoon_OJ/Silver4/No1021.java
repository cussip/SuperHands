package Backjoon_OJ.Silver4;

import java.io.*;
import java.util.*;

public class No1021 {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		int area = Integer.parseInt(st1.nextToken());
		int num = Integer.parseInt(st1.nextToken());
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int arr[] = new int[num];
		for(int i = 0; i < num; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		
		Queue<Integer> qu = new LinkedList<>();		
		for(int i = 0; i < area; i++) {
			qu.add(i + 1);
		}
		
		int rotate = 0;
		int cnt = 0;
		for(int i = 0; i < arr.length; i++) {
			while(arr[i] != qu.peek()) {
				qu.offer(qu.poll());
				rotate++;
			}
			cnt += Math.min(rotate, qu.size() - rotate);
			qu.remove();
			rotate = 0;
		}
		System.out.println(cnt);	
	}
}
