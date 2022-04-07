package condition;

public class Cond27 {

	public static void main(String[] args) {
		// num의 각 자리수를 더하면 얼마인가요?
		int num = 123456;
		int sum = 0;	
		
		while(num > 0) {
			System.out.println(num % 10);
			sum += num % 10;	// 나머지
			num /= 10;			// 10으로 나눈 몫
		}		
		
		System.out.println("각 자리수를 더한 결과 : " + sum);
	}

}
