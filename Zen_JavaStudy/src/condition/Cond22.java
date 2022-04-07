package condition;

public class Cond22 {

	public static void main(String[] args) {
		// 3의 배수인 것은      => x % 3 == 0 (숫자를 3으로 나누어 나머지가 0인 수)
		// 3의 배수가 아닌 것은 => x % 3 != 0 (숫자를 3으로 나누어 나머지가 0이 아닌 수)
		// and => && ,  or => ||
		
		// 1부터 20까지의 정수 중에서 
		// 2의 배수도 아니고 3의 배수도 아닌 정수들의 총합은 얼마인가요?
		// 1 + 5 + 7 + 11 + 13 + 17 + 19 = 73
		int sum = 0;
		for(int i = 1; i <= 20; i++) {
			//if(i % 2 == 0 || i % 3 == 0)
			//	continue;
			//sum = sum + i;
			if(i % 2 != 0 && i % 3 != 0)
				sum = sum + i;
		}
		System.out.println("총합 : " + sum);
		
		
	}

}
