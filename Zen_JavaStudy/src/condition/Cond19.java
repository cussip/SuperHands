package condition;

import java.io.IOException;

public class Cond19 {

	public static void main(String[] args) throws IOException {
		int input = 0;
		
		System.out.println("메뉴를 선택해주십시요.");
		System.out.println("입력을 끝마치시려면 x를 입력하십시요.");
		do {
			System.out.println("1. 짜장면");
			System.out.println("2. 김치찌게");
			System.out.println("3. 설렁탕");
			System.out.println("0. 나가기");
			input = System.in.read();
			System.out.print((char)input);
		} while(input != -1 && input != 'x');

	}

}
