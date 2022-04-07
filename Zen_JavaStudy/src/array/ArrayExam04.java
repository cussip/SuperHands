package array;

public class ArrayExam04 {

	public static void main(String[] args) {
		// arr 배열의 인덱스 번호가 5인 것을 제외하고, 나머지 값들만 화면에 보여주세요.

		int[] arr = { 10, 20, 30, 40, 50, 60, 70, 80, 90, 100 };

		for(int i = 0; i < arr.length; i++) {
			if(i == 5)
				continue;
			System.out.println("arr[" + i + "] => " + arr[i]);
		}
	}

}
