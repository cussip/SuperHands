package variable;

public class Vari05 {

	public static void main(String[] args) {
		// 증감 연산자 : --
		// x-- 는 x = x - 1;과 같다.
		int x = 5; 
		int y = 0;
		y = x--;
		
		System.out.println(x);
		System.out.println(y);
		
		x = 5; y = 0;
		y = --x;
		
		System.out.println(x);
		System.out.println(y);
		
	}

}
