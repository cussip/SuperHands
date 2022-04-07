package array;

import java.util.Scanner;

public class Three69 {

	public static void main(String[] args) {
		// 3, 6, 9의 숫자가 나올 때 박수를 치자!
		// 1 이상 100이하의 값을 입력받아서 게임을 하자!
		Scanner in = new Scanner(System.in);
		System.out.println("1이상 100이하의 양의 정수를 입력하십시오.");
		int count = in.nextInt();
		
		int a, b;
		for(int i = 1; i < count; i++) {
			a = i / 10; // 검사대상을 10으로 나눈 몫
			b = i % 10; // 검사대상을 10으로 나눈 나머지
			
			// System.out.println((i / 10) % 3);
			if(a > 0 && b > 0 && a % 3 == 0 && b % 3 == 0) { // 10단위와 1단위가 모두 3의 배수인 경우
				System.out.println(i + " 짝짝 ");
			} else if(a > 0 && a % 3 == 0) { // 10단위 이상에서 몫이 3의 배수인 경우
				System.out.println(i + " 짝 ");
			} else if(b > 0 && b % 3 == 0) { // 10단위와 1단위에 상관없이 나머지가 3의 배수인 경우
				System.out.println(i + " 짝 ");
			} else {
				System.out.println(i + " --- ");
			}
		}
		
		//------------------------------------------------------------------------------------------------------
		// 1단위와 10단위를 나누어서 별도로 계산한다.
		//------------------------------------------------------------------------------------------------------
		for(int i = 1; i < count; i++) {
			System.out.print(i);
			
			// 10단위 계산
			// 첫번째 조건에서 && i > 9를 사용한 이유는
			// i가 9인 경우에는 i / 10을 하면 몫이 0이 된다.
			// 0 % 3 으로 하면 0이 나오기 때문에 제외시킨다.
			if( (i / 10) % 3 == 0 && i > 9 )		System.out.print(" 짝 ");
			
			// 1단위 계산
			// 두번째 조건에서 && (i % 10) > 0를 사용한 이유는
			// 2자리 수에서 끝의 자리가 0인 경우
			// (i % 10) % 3의 값이 0이므로 박수를 못치게 하는 것이다.
			if( (i % 10) % 3 == 0 && (i % 10) > 0)	System.out.print(" 짝 ");
			
			if( !((i / 10) % 3 == 0 && i > 9) && !((i % 10) % 3 == 0 && (i % 10) > 0) )
				System.out.print(" -- ");
			
			System.out.println();
		}
		
		
		

	} // End - public static void main(String[] args)

} // End - public class Three69





