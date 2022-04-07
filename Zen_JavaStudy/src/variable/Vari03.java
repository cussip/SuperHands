package variable;

public class Vari03 {

	public static void main(String[] args) {
		// Byte Overflow
		byte b = 0; // byte형 변수 b를 선언하고 0으로 초기화 한다.
		int  i = 0; // int 형 변수 i를 선언하고 0으로 초기화 한다.

		// 반복문을 사용하여 b의 값을 1씩 0부터 270까지 증가시킨다.
		for(int x = 0; x <= 270; x++) {
			System.out.print(b++);
			System.out.print('\t');
			System.out.println(i++);
		}
	}

}
