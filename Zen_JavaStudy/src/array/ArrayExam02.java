package array;

public class ArrayExam02 {

	public static void main(String[] args) {
		// arr 배열 중에서 값이 70인 것의 인덱스번호를 알려주세요.

		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

		for(int i = 0; i < arr.length; i++) {
			if(arr[i] == 70)
				System.out.println(i);
		}
	}

}
