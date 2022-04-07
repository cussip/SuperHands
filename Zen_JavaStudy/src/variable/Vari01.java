package variable;

public class Vari01 {

	public static void main(String[] args) {
		
		int x;  	// 선언
		x = 10; 	// 초기화
		int y = 3; 	// 선언과 동시에 초기화한다.
		
		System.out.println("더하기 값은 => " + (x + y));
		System.out.println("빼기의 값은 => " + (x - y));
		System.out.println("곱하기 값은 => " + (x * y));
		System.out.println("나누기 몫은 => " + (x / y));
		System.out.println("나누기 나머지 => " + (x % y));
	}

}
