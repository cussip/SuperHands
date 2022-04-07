package condition;

public class Cond28 {

	public static void main(String[] args) {
		// Fibonnaci 수열
		// 앞의 두 수를 더해서 다음 수를 만들어 나간다.
		// 1, 1, 2, 3, 5, ........
		// 1과 1으로 시작하는 피보나치 수열의 10번째 숫자는 무엇인가요? 55
		int	num1	= 1;	// 첫번째 시작 숫자를 저장하는 변수
		int	num2	= 1;	// 두번째 시작 숫자를 저장하는 변수
		int	num3	= 0;	// 첫번째와 두번째를 더한 값을 저장하는 변수
		
		System.out.print(num1 + ", " + num2);
		
		// 첫번째와 두번째 수는 이미 주어졌기에 8번만 작업을 하면된다.
		for(int i = 0; i < 8; i++) {
			num3 = num1 + num2; // 세번째 값은 첫번째와 두번째를 더해서 구한다.
			System.out.print(", " + num3);
			
			num1 = num2;
			num2 = num3;
			
		}
		
	}

}
