package condition;

public class Star02 {

	public static void main(String[] args) {
		/* 
		 * 별 그리기
		★
		★★
		★★★
		★★★★
		*/
		for(int i = 1; i < 5; i++) {
			for(int j = 1; j <= i; j++) {
				System.out.print("★");
			}
			System.out.println();
		}
	}

}
