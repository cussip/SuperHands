package condition;

public class Cond09 {

	public static void main(String[] args) {
		// 성적에 따라 학점을 구분해주세요.
		int  score = 97;	// 성적
		char grade = ' ';   // 학점

		switch(score/10) {
			case 10:
				
			case 9:
				grade = 'A';
				break;
			case 8:
				grade = 'B';
				break;
			case 7:
				grade = 'C';
				break;
			case 6:
				grade = 'D';
				break;
			default:
				grade = 'F';
		} // End - switch
		System.out.println("당신의 점수는 " + score + "이고, 학점은 " + grade + "입니다.");
	}

}
