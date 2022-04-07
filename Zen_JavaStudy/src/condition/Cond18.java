package condition;

public class Cond18 {

	public static void main(String[] args) {
		int	sum = 0;	// 누적된 값을 저장할 변수
		int i   = 0;	// 순차적으로 증가되는 값을 저장할 변수

		// 1 부터 몇까지 더해나가면 누적된 숫자가 100을 넘지않은 
		// 제일 큰 수가 되는지 알려주세요.
		// 정답 : 13 - 91
		while(sum + i <= 100) { 
			sum = sum + ++i;
			System.out.println(i + "--" + sum);
			//++i;
		}
	}

}
