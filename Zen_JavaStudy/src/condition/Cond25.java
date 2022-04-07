package condition;

public class Cond25 {

	public static void main(String[] args) {
		// 2개의 주사위를 던졌습니다.
		// 눈의 합이 6이 되는 모든 경우의 수를 출력하세요.
		// 1 + 5, 2 + 4, 3 + 3, 4 + 2, 5 + 1
		// 2개의 for문을 사용하여 문제를 풀어봅시다.
		for(int i = 1; i <= 6; i++) { // 첫번째 주사위의 경우의 수
			for(int j = 1; j <= 6; j++) { // 두번째 주사위의 경우의 수
				if(i + j == 6) // 두눈의 합이 6인 것만 화면에 보이면 된다.
					System.out.println(i + " + " + j + " = " + (i+j));
			}
		}
	}

}



