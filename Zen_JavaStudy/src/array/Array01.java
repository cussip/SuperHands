package array;

public class Array01 {

	public static void main(String[] args) {
		// 총점과 평균을 구해보자.
		int		sum		= 0;	// 총점을 저장할 변수
		float 	average	= 0;	// 평균을 저장할 변수
		
		int[] score	= {100, 54, 70, 88, 45, 95, 64, 77, 50, 82};
		
		// 총점을 구한다.
		// score.length : 배열변수.length => 배열이 갖고 있는 요소의 갯수
		for(int i = 0; i < score.length; i++) {
			sum += score[i]; // sum = sum + score[i];
		}
		average = sum / (float)score.length;
		
		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + average);
		System.out.println("평균 : " + (int)average);
		
		for(int i = 0; i < score.length; i++)
			System.out.print(i + " : " + score[i] + "\t");
		
	} // End - public static void main(String[] args)

} // End - public class Array01














