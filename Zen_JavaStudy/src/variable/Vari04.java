package variable;

public class Vari04 {
	
	public static void main(String[] args) {
		// 증감 연산자
		// x++; 와 x = x + 1; 는 같은 표현이다.
		int x = 5; int y = 0;
		// x++; x의 값을 변화시키기 전에 계산을 하고 난 후에 x값을 증가시킨다.
		y = x++;
		
		System.out.println(x);
		System.out.println(y);
		
		//int x = 5; int y = 0; <= 중복오류
		x = 5; y = 0;
		// ++x; x의 값을 먼저 증가시키고 증가된 값을 가지고 계산을 한다.
		y = ++x;
		
		System.out.println(x);
		System.out.println(y);
	}
	
}




