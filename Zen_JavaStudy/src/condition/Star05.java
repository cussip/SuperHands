package condition;

public class Star05 {

	public static void main(String[] args) {
		/* 별 그리기
		★★★★ 
	  	★★★
	    ★★
	    ★
		 */

		int lineNum = 4;
		for(int line = 1; line <= lineNum; line++) {
			for(int col = 1; col <= lineNum -line + 1; col++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
		//-----------------------------------------------------------
		lineNum = 4;
		for(int line = 0; line < lineNum; line++) {
			for(int col = 0; col < lineNum -line; col++) {
				System.out.print("★");
			}
			System.out.println();
		}
		
	}

}


