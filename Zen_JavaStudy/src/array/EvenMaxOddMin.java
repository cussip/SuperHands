package array;

import java.util.Scanner;

//-------------------------------------------------------------------------------------------------
// public class EvenMaxOddMin
//-------------------------------------------------------------------------------------------------
public class EvenMaxOddMin {

	//-------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		// 4자리 이하의 10개의 정수를 입력받아서,
		// 짝수 중에서 가장 큰 값과, 홀수 중에서 가장 작은 값을 출력하십시오.
		Scanner	in	= new Scanner(System.in);
		int[]	num	= new int[10];
		int		max	= 0;	// 짝수 중에서 최대값을 저장할 변수
		int		min	= 0;	// 홀수 중에서 최소값을 저장할 변수
		
		for(int i = 0; i < num.length; i++) {
			System.out.print((i+1) + " 번째를 수를 입력하세요 : ");
			num[i] 	= in.nextInt();
			
			// 최소값 변수에 0이 저장되서 시작하므로, 처음 값은 무조건 min에 저장해야 한다.
			if(i == 0) min	= num[0];
			
			if(num[i] % 2 != 0) { // 홀수인 경우
				if(num[i] < min) {
					min = num[i];
				}
			} else { // 짝수인 경우
				if(num[i] > max) {
					max = num[i];
				}
			}
		}
		// 모든 작업이 끝나면 최소값과 최대값을 화면에 보여준다.
		System.out.print("최소값:" + min + ", 최대값:" + max);

	} // End - public static void main(String[] args)

} // End - public class EvenMaxOddMin














