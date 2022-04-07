package array;

import java.util.Scanner;

public class ArrayExam09 {

	public static void main(String[] args) {

		String[] name 	= { "dooley", "gildong", "sooil", "choonhyang", "soonae"};
		int[]	 height = new int[name.length];
		
		Scanner scanner = new Scanner(System.in);
		
		int total = 0; // 키의 평균을 저장하는 변수
		for(int i = 0; i < name.length; i++) {
			System.out.print(name[i] + "의 키를 입력하세요 : ");
			height[i] = scanner.nextInt(); // 저장된 사람만큼 순서대로 키를 입력한다.
			total 	 += height[i]; // total변수에 입력한 신장을 누적시킨다.
		}
		
		// 친구들의 키를 모두 보여주세요.
		for(int i = 0; i < name.length; i++) {
			System.out.println(name[i] + "의 키는 " + height[i] + "입니다.");
		}
		
		// 친구들의 키의 합계
		System.out.println("키의 합계 : " + total);
		// 친구들의 평균 키
		System.out.println("평균 키 : " + (total / name.length));
		
	} // End - public static void main(String[] args)

}





