package condition;

public class Cond30 {

	public static void main(String[] args) {
		// 1 ~ 100 사이의 임의의 정수를 구한다.
		// Math.random() => 0 ~ 0.99999999999999
		// Math.random() * 100 => 0 ~ 99.999999999999
		// (int)(Math.random() * 100) => 0 ~ 99
		// (int)(Math.random() * 100) + 1 => 1 ~ 100
		int answer = (int)(Math.random() * 100) + 1; // 문제
		// System.out.println(answer);
		int input	= 0; // 사용자가 입력하는 값을 저장할 변수
		int count	= 0; // 정답을 맞추기 위해 입력한 횟수를 저장할 변수
		
		// 화면으로 부터 사용자의 입력을 받기 위해서 Scanner클래스를 사용한다.
		java.util.Scanner keyboard = new java.util.Scanner(System.in);
		
		do {
			count++; // 게임이 시작되었으므로 카운트를 1늘린다.
			System.out.println("1 부터 100 사이의 정수를 입력하세요 : " );
			
			input = keyboard.nextInt(); // 입력한 값을 input에 저장한다.
			//System.out.println(input);
			
			// 1 ~ 100사이의 정수를 입력하지 않았으면,
			// 다시 입력하라고 메시지를 보여주고, count에서 1을 빼주자!!!
			if(input < 1 || input > 100) {
				System.out.println("1부터 100사이의 정수를 입력하셔야 합니다.");
				System.out.println("다시 입력해 주십시요.");
				count--; // 잘못입력한 것은 횟수에서 제외한다.
				continue; // 다시 숫자를 입력하는 부분으로 이동시킨다.
			}
			
			// 정답과 내가 입력한 값을 비교해서 메시지를 처리한다.
			if(answer > input) {
				System.out.println("더 큰 수를 입력하세요.");
			} else if(answer < input) {
				System.out.println("더 작은 수를 입력하세요.");
			} else {
				System.out.println("정답입니다. " + count + "번만에 맞추셨습니다.");
				break; // 정답인 경우는 반복을 빠져나가게 한다.
			}
			
		} while(true);
		
		

	} // End - public static void main(String[] args)

}











