package condition;

public class Cond04 {

	public static void main(String[] args) {
		// Cond03.java 를 삼항연산자를 이용하여 만들어보세요.
		int	 score = 87;
		char grade = ' ';
		/*
		if(score >= 90) {
			grade = 'A';
		} else if(score >= 80) {
			grade = 'B';
		} else {
			grade = 'C';
		}
		*/
		grade = score >= 90 ? 'A' : (score >= 80 ? 'B' : 'C') ;
		

		System.out.println("당신의 등급은 " + grade + "입니다.");
	} // End - public static void main(String[] args)

} // End - public class Cond04
