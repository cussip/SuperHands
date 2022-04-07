package condition;

public class Star08 {

	public static void main(String[] args) {
		/* 모래시계
		★★★★★★★★★
		_★★★★★★★
		__★★★★★
		___★★★
		____★
		____★
		___★★★
		__★★★★★
		_★★★★★★★
		★★★★★★★★★ 
			 */
		int lineNumber = 5;
		// 역삼각형
		for(int line = lineNumber; line >= 1; line--) {
			// 맨 윗줄은 공백이 없고, 다음 줄 부터 맨앞에 공백을 1씩 증가시킨다.
			for(int col = 0; col < lineNumber - line; col++) {
				System.out.print("_");
			}
			// (줄 수 x 2 - 1) 보다 작거나 같을 때까지 ★을 그려나간다.
			for(int k = 1; k < line * 2; k++) { // k <= line * 2 -1;
				System.out.print("★");
			}
			System.out.println(); // 줄바꿈
		}
		// 정삼각형
		for(int line = 1; line <= lineNumber; line++) {
			for(int col = 1; col <= lineNumber - line; col++) {
				System.out.print("_");
			}
			for(int col = 1; col <= line * 2 -1; col++) {
				System.out.print("★");
			}
			System.out.println(); // 줄바꿈
      	}
		
		//-------------------------------------------------------------------------------
		// 역삼각형
		// 맨 마지막의 ★을 그리지 않으려면 조건부분(line >= 1)에 1을 더한다.
		for(int line = lineNumber; line >= 1 + 1; line--) {
			// 맨 윗줄은 공백이 없고, 다음 줄 부터 맨앞에 공백을 1씩 증가시킨다.
			for(int col = 0; col < lineNumber - line; col++) {
				System.out.print("_");
			}
			// (줄 수 x 2 - 1) 보다 작거나 같을 때까지 ★을 그려나간다.
			for(int k = 1; k < line * 2; k++) { // k <= line * 2 -1;
				System.out.print("★");
			}
			System.out.println(); // 줄바꿈
		}
		// 정삼각형
		// 맨위의 ★을 않그리려면 초기값 부분(int line = 1;)에 1을 더한다.
		for(int line = 1; line <= lineNumber; line++) {
			for(int col = 1; col <= lineNumber - line; col++) {
				System.out.print("_");
			}
			for(int col = 1; col <= line * 2 -1; col++) {
				System.out.print("★");
			}
			System.out.println(); // 줄바꿈
      	}

	}

}











