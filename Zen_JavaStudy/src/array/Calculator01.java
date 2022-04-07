package array;

import java.util.Scanner;

public class Calculator01 {

	public static void main(String[] args) {
		// 간단한 계산기
		Scanner in = new Scanner(System.in);
		float	num1;		// 첫번째 숫자를 저장할 변수
		float	num2;		// 두번째 숫자를 저장할 변수
		String	oper;		// 연산자를 저장할 변수(+, -, /, *)
		boolean	exitFlag;	// 반복문을 탈출하기 위해 사용하는 변수
		
		do {
			System.out.print("첫번째 숫자 : ");
			num1		= in.nextFloat();
			exitFlag	= true;
			
			do {
				System.out.print("연산자 입력 : ");
				oper	= in.next();
				
				switch(oper) {
					case "+":
					case "-":
					case "/":
					case "*":
						exitFlag	= false;
						break;
					default:
						System.out.print("연산자를 다시 입력해주세요.\n");
				}
			} while(exitFlag);
			
			System.out.print("두번째 숫자 : ");
			num2	= in.nextFloat();
			
			// switch()문을 이용하여 입력한 숫자 2개에 대한 연산 결과를 보여주세요.
			switch(oper) {
				case "+":	System.out.println(num1 + num2);	break;
				case "-":	System.out.println(num1 - num2);	break;
				case "/":	System.out.println(num1 / num2);	break;
				case "*":	System.out.println(num1 * num2);	break;
				default:
					System.out.println("처음부터 다시 입력하십시요.");
					continue;
			}
			
			System.out.println("계산을 계속하려면 y나 Y를 입력하십시요.");
			System.out.println("프로그램을 종료하려면 아무값이나 입력하십시요.");
			String con = in.next();
			if(con.equals("y") || con.equals("Y")) {
				continue;
			} else {
				System.out.println("프로그램을 종료합니다.");
				break;
			}
			
		} while(true); // 첫번째 do ~ while()
		
		in.close();
		
	} // End - public static void main(String[] args)

} // End - public class Calculator01














