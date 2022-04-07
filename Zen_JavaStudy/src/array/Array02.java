package array;

public class Array02 {

	public static void main(String[] args) {
		int[] score	= {20, 54, 70, 88, 45, 95, 64, 77, 50, 82};
		System.out.println("방의 갯수 : " + score.length);
		
		int	max	= score[0];	// 배열의 첫번째 값으로 최대값을 초기화한다.
		int	min	= score[0]; // 배열의 첫번째 값으로 최소값을 초기화한다.
		
		for(int i = 0; i < score.length; i++) {
			if(max < score[i])	max = score[i];
			if(min > score[i])	min = score[i];
		}
		
		System.out.println("최대값 : " + max);
		System.err.println("최소값 : " + min);
		
		int[] num = new int[10];
		for(int i = 0; i < num.length; i++)
			System.out.print(num[i] + ", ");
		
		System.out.println();
		for(int i = 0; i < num.length; i++)
			num[i] = i + 1;

		for(int i = 0; i < num.length; i++)
			System.out.print(num[i] + ", ");
		
	} // End - public static void main(String[] args)

} // End - public class Array02
