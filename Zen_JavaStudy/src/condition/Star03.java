package condition;

public class Star03 {

	public static void main(String[] args) {
		/* 별 그리기
		☆☆☆★
		☆☆★★
		☆★★★
		★★★★ 
		*/
		
		int lineNumber = 10;
		for(int i = 1; i <= lineNumber; i++) { // 세로방향
			for(int j = lineNumber; j > 0; j--) { // 가로방향
				if(j > i) 	System.out.print("  ");
				else		System.out.print("★");
			}
			System.out.println();
		}

	}

}















