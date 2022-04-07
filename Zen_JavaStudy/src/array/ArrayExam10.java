package array;

import java.util.Scanner;

public class ArrayExam10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] subject = { "Java", "JSP", "html", "Android", "Spring" }; // 시험과목
		int[]	 score   = { 88,     91,    77,      82,       60 };       // 과목에 따른 성적
		
		Scanner sc = new Scanner(System.in);
		
		System.out.println("과목을 입력하면 시험성적을 볼 수 있습니다.");
		while(true) {
			System.out.print("과목명을 입력하세요 : ");
			String name = sc.next();
			
			// toLowerCase() 는 모든 문자열을 소문자로 변환시킨다.
			// toUpperCase() 는 모든 문자열을 대문자로 변환시킨다.
			System.out.println("보고 싶은 과목은 " + name);
			if(name.toLowerCase().equals("stop".toLowerCase())) { // stop을 입력하면 프로그램을 종료시킨다.
				break;
			}
			
			for(int i = 0; i < subject.length; i++) {
				if(subject[i].toUpperCase().equals(name.toUpperCase())) {
					System.out.println(subject[i] + "과목 점수 : " + score[i]);
				}
			}
			
		}
		
	} // End - public static void main(String[] args)

} // End - public class ArrayExam10







