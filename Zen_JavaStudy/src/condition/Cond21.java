package condition;

public class Cond21 {

	public static void main(String[] args) {

		// 1 부터 10까지 정수를 출력하는데,
		// 3의 배수는 빼고 보여주세요.
		for(int i = 1; i <= 10; i++) {
			if(i % 3 == 0) // 3의 배수
				continue; // 반복문의 나머지부분을 실행하지 않고, 앞으로 간다.
			System.out.println(i);
		}

	}

}
