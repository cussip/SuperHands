package condition;

public class Star06 {

	public static void main(String[] args) {
		/* 별 그리기
		  ★★★★★
		   ★★★★
		    ★★★
		     ★★
		      ★
		 */

		int lineNum = 5;
		for(int line = 0; line < lineNum; line++) {
			// 공백을 하나씩 늘려나가면서 그린다.
			for(int col = 0; col < line; col++) {
				System.out.print("_");
			}
			// 공백을 먼저그리고 난 후에 ★을 그린다.
			for(int col = 0; col < lineNum-line; col++) {
				System.out.print("★");
			}
			System.out.println();
		}
		//-------------------------------------------------------
		for(int line = lineNum; line > 0; line--) {
			for(int col = lineNum; col > 0; col--) {
				if(line < col)	System.out.print("_");
				else			System.out.print("★");
			}
			System.out.println();
		}
	}

}




