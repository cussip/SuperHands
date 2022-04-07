package condition;

public class OneTo100Sosu {

	public static void main(String[] args) {
		// 소수 : 1 과 자기자신으로만 나누어지는 수
		// 2 부터 100까지의 정수들의 모든 소수를 구하십시오.
		// 2 3 5 7 11 13 17 19 23 29 31 37 41 43 47 53 59 61 67 71 73 79 83 89 97
		
		// 작업대상이 되는 수가 1을 제외한 나머지 수로 나누어지는 횟수
		int count = 0;
		
		// num <= 검사 대상이 되는 숫자
		for(int num = 2; num <= 100; num++) {
			for(int j = 2; j <= num; j++) { // num를 검사하는 횟수
				// num를 2부터 num까지 정수로 순차적으로 나누어 나머지가 0인 횟수를 증가시킨다.
				if(num % j == 0) { // 약수
					count++;
				}
			}
			// num를 2부터 num까지 정수로 순차적으로 나누어 나머지가 0인 횟수가 1이면 소수이다.
			// 나누어 나머지가 0인 횟수가 1인 것들(소수)만 출력한다.
			if(count == 1) {
				System.out.print(num + ", ");
			}
			
			count = 0;
		}
		
		
		
	} // End - public static void main(String[] args)

} // End - public class OneTo100Sosu











