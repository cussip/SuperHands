package array;

public class Array10 {

	public static void main(String[] args) {
		// 모든 수의 총합과 평균을 구하십시오.
		int[][] arr = {
				{ 5,  5,  5,  5,  5},
				{10, 10, 10, 10, 10},
				{20, 20, 20, 20, 20},
				{30, 30, 30, 30, 30}
		};
		int	total	= 0;	// 모든 수를 더한 값을 저장할 변수
		float average	= 0;	// 평균을 저장할 변수
		
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				total += arr[i][j];
			}
		}
		average = total / (float)(arr.length * arr[0].length);
		System.out.println("합계 : " + total);
		System.out.println("평균 : " + average);
		
	} // End - public static void main(String[] args)

} // End - public class Array10







