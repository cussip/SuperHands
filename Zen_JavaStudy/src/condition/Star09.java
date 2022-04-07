package condition;

public class Star09 {

	public static void main(String[] args) {
		/* X자모양의 별 그리기
		★      ★ 
	  	  ★  ★
	        ★ 
	      ★  ★
        ★      ★
		*/ 
		int lineNumber = 5;
		for(int row = 0; row < lineNumber; row++) {
			for(int col = 0; col < lineNumber; col++) {
				if(row == col) { // 좌상단에서 우하단으로 별을 그린다.
					System.out.print("★");
				} else if(row + col == lineNumber - 1) { // 우상단에서 좌하단으로 별을 그린다.
					System.out.print("★");
				} else { // 그외에는 공백 으로 그린다.
					System.out.print(" ");
				}
			}
			System.out.println(); // 한 줄에 대한 작업이 끝나면 줄바꿈을 한다.
		}
		
		//--------------------------------------------------------------------------
		
		for(int row = 0; row < lineNumber; row++) {
			for(int col = 0; col < lineNumber; col++) {
				// 좌상단에서 우하단으로 별을 그린다. 우상단에서 좌하단으로 별을 그린다.
				if( (row == col) || (row + col == lineNumber - 1) ) { 
					System.out.print("★");
				} else { // 그외에는 공백 으로 그린다.
					System.out.print(" ");
				}
			}
			System.out.println(); // 한 줄에 대한 작업이 끝나면 줄바꿈을 한다.
		}
		

	}

}












