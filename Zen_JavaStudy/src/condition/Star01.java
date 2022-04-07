package condition;

public class Star01 {

	public static void main(String[] args) {
		// 별 : ㅁ ★
		// 2차원 배열 형태의 별 찍기 
		// ★★★★
		// ★★★★ 
		// ★★★★
		for(int i = 1; i <= 3; i++) { // 세로방향
			for(int j = 1; j <= 4; j++) { // 가로방향
				System.out.print("★");
			}
			System.out.println();
		}

	}

}
