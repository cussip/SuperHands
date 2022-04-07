package array;

import java.util.Random;

public class Random01 {

	public static void main(String[] args) {

		// nextInt()	  : int 타입의 최소~최대범위 안에서 랜덤한 숫자를 리턴합니다.
		// nextInt(int i) : 0 부터 i전까지의 랜덤한 숫자를 리턴한다.
		Random random = new Random();

		System.out.println(random.nextInt());
		System.out.println(random.nextInt(4)); // 0, 1, 2, 3
		
		// 랜덤한 수의 범위를 지정해서 찾을 수 있도록 한다.
		int min	= 3;
		int max = 10;
		
		// int value = random.nextInt(max + min) + min;
		int value = random.nextInt(max) + min;
		System.out.println(value);
	}

}




