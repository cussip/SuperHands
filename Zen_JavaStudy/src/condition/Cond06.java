package condition;

public class Cond06 {

	public static void main(String[] args) {
		// Math.random() => 0 이상 1미만의 임의의 실수 (0, 0.1, 0.99999999)

		int score;
		System.out.println( Math.random() );
		
		// 0 ~ 9 사이의 정수 값을 score에 넣는다.
		// score = (int)(Math.random() * 10); 

		// 1 ~ 10 사이의 정수 값을 score에 넣는다.
		score = (int)(Math.random() * 10) + 1; 

		System.out.println(score);
		
		switch(score * 100) {
			case 100: // 조회
				System.out.println("당신의 점수는 100점이고, 상품은 연필입니다.");
				break;
				
			case 200: // 입력
				System.out.println("당신의 점수는 200점이고, 상품은 자전거입니다.");
				break;
				
			case 300: // 수정
				System.out.println("당신의 점수는 300점이고, 상품은 노트북입니다.");
				break;
				
			case 400: // 삭제
				System.out.println("당신의 점수는 400점이고, 상품은 자동차입니다.");
				break;
				
			default:
				System.out.println("다음 기회에.....");
		}
		
	} // End - main()

} // End - class
