package variable;

public class Vari08 {

	public static void main(String[] args) {
		// 삼항 연산자 =>   1항 ? 2항 : 3항
		// 조건식 ? 1식 : 2식

		int x =  10;
		int y = -10;
		
		int absX = (x >= 0) ? x : -x;
		int absY = (y >= 0) ? y : -y; // -y ==> -1 x y
		
		System.out.println("x의 절대값은 " + absX);
		System.out.println("y의 절대값은 " + absY);
	}

}
