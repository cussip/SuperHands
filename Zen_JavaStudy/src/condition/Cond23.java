package condition;

public class Cond23 {

	public static void main(String[] args) {
		// 1 + (1+2) + (1+2+3) + ..... + (1+2+3+.....+10)의 결과가 나오도록 만들어 주세요.
		// 정답 : 220
		int sum			= 0; // 소계를 위한 변수
		int totalSum	= 0; // 총합 : 소계를 모두 더한 수를 담을 변수
		
		for(int i = 1; i <= 10; i++) {
			sum 	 	= sum 		+ i;
			totalSum 	= totalSum 	+ sum;
			
			System.out.println(i + ":" + sum + ":" + totalSum);
			
		}
		System.out.println("총합 : " + totalSum);
		
	}

}
