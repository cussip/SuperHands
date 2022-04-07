package condition;

public class Cond29 {

	public static void main(String[] args) {
		// 회문수(Palindrome) : 앞으로 읽어도, 거꾸로 읽어도 같은 숫를 말합니다.
		// 회문수의 예) 11111,  12321, 1357531
		
		// number가 회문수 인지 아닌지 알려주세요?
		int	number	= 12345;
		int temp	= number;
		int result	= 0;	// 변수 number를 거꾸로 만들어 저장할 변수
		
		while(temp != 0) {
			System.out.println(temp + "==" + result);
			result = result * 10 + temp % 10;
			temp = temp / 10;
		}
		
		if(number == result) {
			System.out.println(number + "는 회문수입니다.");
		} else {
			System.out.println(number + "는 회문수가 아닙니다.");
		}
		
		
		
		// 결과 : 회문수 인가 아닌가를 출력하세요.
	}

}
