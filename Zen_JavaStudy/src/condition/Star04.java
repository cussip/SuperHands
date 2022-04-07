package condition;

public class Star04 {

	public static void main(String[] args) {
		/* 별 그리기
		 * 
		 * 공통되는 것들과 반복되는 것들을 파악하자!!! 
			 ★
			★★★
		   ★★★★★
		  ★★★★★★★
		 */
		int lineNum = 4;
		for(int i = 0; i < lineNum; i++) {
			// 첫번째 줄에는 줄 수에서 -1한 갯수만큼 공백을 출력시키고,
			// 두번째 줄부터 1씩 줄여나가면서 공백을 출력시킨다.
			for(int j = 0; j < lineNum -1 - i; j++) {
				// lineNum -1 에서 -1을 한 이유는 i가 0부터 시작했기 때문에
				System.out.print(" ");
			}
			// 1, 3, 5, ... 순으로 ★을 그린다. 즉, 1부터 시작해서 2씩 증가시킨다.
			// 첫번째 줄에는 ★을 한개그리고,
			// 두번째 줄에는 2개식 더 ★을 그린다.
			for(int j = 0; j < i*2 + 1; j++) {
				System.out.print("★");
			}
			
			// 1 줄에 대한 작업이 끝나면 줄바꿈을 한다.
			System.out.println();
		}
		
		//--------------------------------------------------------------
		// 별이 나타나기 전의 공백은 lineNum - 1만큼 그려주면 된다.
		// ★ 은 (줄수 x 2) - 1만큼 그리면 된다.
		// 공백과 ★을 합쳐 첫번째 줄에는 4개, 두번째 줄에는 5개로 하나씩 늘어난다.
		// lineNum가 4이면
		// 첫번째 줄 : ___★
		// 두번째 줄 : __★★★
		// 세번째 줄 : _★★★★★
		// 네번째 줄 : ★★★★★★★
		lineNum = 4; // 그려야될 줄의 수
		for(int line = 1; line <= lineNum; line++) {
			for(int col = 1; col <= lineNum+line-1; col++) {
				if(col <= lineNum-line)	System.out.print("_");
				else					System.out.print("★");
			}
			System.out.println();
		}
				 
		
	}

}













