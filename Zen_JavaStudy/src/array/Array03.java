package array;

public class Array03 {

	public static void main(String[] args) {
		int[] number = new int[10];
		for(int i = 0; i < number.length; i++) {
			number[i] = i;
			System.out.print(number[i] + ", ");
		}
		System.out.println();
			
		for(int i = 0; i < 100; i++) {
			int n = (int)(Math.random() * 10); // 0 ~ 9사이의 임의의 정수를 추출한다.
			System.out.println("추출한 값 : " + n);
			// 임의로 추출한 정수에 해당하는 방의 값과 0번째 방의 값을 교환한다.
			int imsi	= number[0];
			number[0]	= number[n];
			number[n]	= imsi;
		}
		// 값이 섞여진 방들의 값을 출력한다.
		for(int i = 0; i < number.length; i++) {
			System.out.print(number[i] + ", ");
		}
		

	}

}
