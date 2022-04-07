package condition;

public class Star07 {

	public static void main(String[] args) {
		//별을 다이아몬드형태로 출력하세요.
		/*
		   ★
		  ★★★
		 ★★★★★
		  ★★★
		   ★
		*/
		int lineNum = 5; // 줄의 갯수
		for(int line = 0; line < lineNum; line++) {
			for(int col = 0; col < lineNum; col++) {
				if(line <= lineNum / 2) { //윗쪽 영역
					if(line + col <= lineNum / 2 -1) { // 왼쪽 위 공백 그리기
						System.out.print(".");
					} else if(col - line >= lineNum / 2 + 1) { // 오른쪽 위 공백 그리기
						System.out.print("_");
					} else {
						System.out.print("★");
					}
				} else if(line > lineNum /2) { // 아래쪽 영역
					if(line - col >= lineNum /2 + 1) { // 왼쪽 밑 공백
						System.out.print(".");
					} else if(line + col >= lineNum / 2 *3 + 1) {
						System.out.print("_"); // 오른쪽 아래 공백
					} else {
						System.out.print("★");
					}
				}
			}
			System.out.println(); // 줄바꿈
		}
		
		//-------------------------------------------------------------------------
		for(int line = 0; line < lineNum; line++) {
			for(int col = 0; col < lineNum; col++) {
				if(line <= lineNum / 2) { //윗쪽 영역
					// 왼쪽 위 공백 그리기 와  오른쪽 위 공백 그리기
					if( (line + col <= lineNum / 2 -1) || (col - line >= lineNum / 2 + 1) ) { 
						System.out.print("_");
					} else {
						System.out.print("★");
					}
				} else if(line > lineNum /2) { // 아래쪽 영역
					//왼쪽 밑 공백 과 오른쪽 아래 공백
					if( (line - col >= lineNum /2 + 1) || (line + col >= lineNum / 2 *3 + 1) ) {
						System.out.print("_"); 
					} else {
						System.out.print("★");
					}
				}
			}
			System.out.println(); // 줄바꿈
		}
	}

}

















