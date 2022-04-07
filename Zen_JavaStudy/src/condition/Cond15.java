package condition;

public class Cond15 {

	public static void main(String[] args) {
		// 1단부터 9단까지 구구단을 출력해보세요.
		for(int x = 1; x <= 9; x++) {
			for(int y = 1; y <= 9; y++) {
				System.out.print(x + "x" + y + "=" + (x*y) + "\t");
			}
			System.out.println(); // 줄바꿈
		}
	}

}
