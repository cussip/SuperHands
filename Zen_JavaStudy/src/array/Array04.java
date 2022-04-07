package array;

public class Array04 {

	public static void main(String[] args) {
		int		room		= 25;	// 방의 갯수
		int[]	number	= new int[room]; // 랜덤한 정수를 저장할 방
		int[]	counter	= new int[room]; // 랜덤한 숫자에 해당하는 갯수를 저장할 방
		
		// 10개의 방에 랜덤하게 추출한 정수를 저장하자.
		for(int i = 0; i < number.length; i++) {
			// 0 ~ 9 사이의 랜덤한 정수를 추출하자.
			int r = (int)(Math.random() * room);
			
			// 추출한 값을 number 방에 저장하자.
			number[i] = r;
		}
		System.out.println();
		// 각 방에 들어있는 숫자를 출력한다.
		for(int i = 0; i < number.length; i++) {
			System.out.print(number[i] + ", ");
		}
		System.out.println();
		// number방에 있는 숫자들이 숫자별(0~9)로 총 몇개씩 있나요?
		for(int i = 0; i < number.length; i++) {
			// counter[정수형 값 또는 정수형 변수] 
			// counter[number[i]] = counter[number[i]] + 1;
			counter[number[i]]++;
		}
		
		// 각 숫자의 종류별 갯수를 보여준다.
		for(int i = 0; i < counter.length; i++) {
			System.out.println(i + "의 갯수 : " + counter[i]);
		}
		

	} // End - public static void main(String[] args)

} // End - public class Array04






