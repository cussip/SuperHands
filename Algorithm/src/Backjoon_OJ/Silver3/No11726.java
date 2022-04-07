package Backjoon_OJ.Silver3;

import java.io.*;

public class No11726 {

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(
							new InputStreamReader(System.in));
		int cnt = Integer.parseInt(br.readLine());
		br.close();

		long sumTotCnt = 1l;
		int two = 0;
		int one = 0;
		long n = 1l;
		long r = 1l;
		int arr = 0;
		
		while(cnt > 1) {
			two++;
			cnt -= 2;
			
			while(arr < two) {
				arr++;
			}
			
			while(cnt > 0) {
				arr++;
				cnt--;
				one++;
			}	
			
			for(int j = 0; j < two; j++) {
				n *= (arr - j) % 10007;
				r *= (two - j) % 10007;
			}
			
			sumTotCnt += (n / r) % 10007;
			n = 1;
			r = 1;
			cnt += one;
			one = 0;
			arr = 0;
		}
		System.out.println(sumTotCnt % 10007);
	}
}

// 결론적으론 피보나치 수열에 따라 수량이 증가하는 것으로 보여짐
// 단, 위 코딩을 피보나치 수열의 코딩으로 사용하기엔 지나치게 연산량이 많아서 다시 작성


