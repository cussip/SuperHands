package array;

public class Array06 {

	public static void main(String[] args) {
		// 행의 갯수 : score.length
		// 열의 갯수 : score[2].length
		
		int[][] score = {
			{88, 70, 91},	// 1번 학생의 국영수 점수
			{50, 88, 70},	// 2번 학생의 국영수 점수
			{77, 67, 95},	// 3번 학생의 국영수 점수
			{45, 92, 88},	// 4번 학생의 국영수 점수
			{80, 66, 78}	// 5번 학생의 국영수 점수
		};
		System.out.println("행의 갯수 : " + score.length);
		for(int i = 0; i < score.length; i++)
			System.out.print(i + "행의 열의 갯수:" + score[i].length + "  ");
		System.out.println();
		
		int	num			= 3;	// 시험 과목수
		int korTotal	= 0;	// 모든 학생의 국어 총점
		int engTotal	= 0;	// 모든 학생의 영어 총점
		int matTotal	= 0;	// 모든 학생의 수학 총점
		
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균");
		System.out.println("============================================================");
		for(int i = 0; i < score.length; i++) 
		{
			int sum = 0; // 개인의 과목별 점수를 더해서 저장할 변수
			korTotal	+= score[i][0];
			engTotal	+= score[i][1];
			matTotal	+= score[i][2];
			
			// 학생의 번호
			System.out.print((i+1) + "\t");
			// 학생 개개인의 국어, 영어, 수학 점수를 보여준다.
			for(int j = 0; j < score[i].length; j++) 
			{
				// 학생의 과목별 점수를 합산한다.
				sum += score[i][j]; 
				System.out.print(score[i][j] + "\t");
			}
			System.out.print(sum + "\t");
			System.out.print(sum / score[i].length);
			System.out.println();
		}
		System.out.println("============================================================");
		System.out.print("총점\t" + korTotal + "\t" + engTotal + "\t" + matTotal + "\t");
		System.out.print((korTotal+engTotal+matTotal) + "\t");
		System.out.println((korTotal+engTotal+matTotal) / (score.length*num));
		
	} // End - public static void main(String[] args)

} // End - public class Array06











