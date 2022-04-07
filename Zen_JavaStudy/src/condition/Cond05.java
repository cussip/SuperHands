package condition;

public class Cond05 {

	public static void main(String[] args) {
		int score = 82;
		// char grade = 'A+';
		String grade = "";

		System.out.println("당신의 시험성적은 " + score + "점입니다.");
		
		if(score >= 90) { // 시험성적이 90점 이상이면 A학점
			grade = "A";
			if(score >= 98) {
				grade += "+"; // 왼쪽과 같은 것이다. grade = grade + "+";
			} else if(score < 94) {
				grade = grade + "-";
			//} else if(score >= 94 && score < 98) {
			//	grade = grade + "";
			}
		} else if(score >= 80) { // 시험성적이 80점 이상이면 B학점
			// 삼항연산자를 이용하여 작성해주십시오.
			grade = (score >= 88) ? "B+" : ((score < 84) ? "B-" : "B");
		} else { // 시험성적이 80점 미만이면 C학점
			grade = "C";
		}
		
		System.out.println("당신의 학점은 " + grade + "입니다.");
	}

}
