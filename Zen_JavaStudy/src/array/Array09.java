package array;

public class Array09 {

	public static void main(String[] args) {
		// 배열 arr 에 담겨있는 모든 값을 더해서 보여주세요.
		int[] 	arr = {10, 20, 30, 40, 50};
		int		sum = 0;

		for(int i = 0; i < arr.length; i++)
			sum += arr[i];
		
		System.out.println("합계 : " + sum);
	}

}
