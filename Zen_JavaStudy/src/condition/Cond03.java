package condition;

public class Cond03 {

	public static void main(String[] args) {
		// 조건문
		int  score = 95;  // 시험성적
		char grade = ' '; // 시험등급을 저장하기 위한 변수
		
		if(score >= 90) {
			grade = 'A';
		} else if(score >= 80) {
			grade = 'B';
		} else {
			grade = 'C';
		}
		System.out.println("당신의 등급은 " + grade + "입니다.");

	} // End - public static void main(String[] args)

} // End - public class Cond03



