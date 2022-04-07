package array;

public class Array05 {

	public static void main(String[] args) {
		// 45개의 정수 값을 저장하기 위한 배열을 생성한다.
		int[]	ball	= new int[45];

		// 45개의 방에 1 ~ 45의 정수값을 순서대로 저장한다.
		for(int i = 0; i < ball.length; i++)
			ball[i] = i+1;
		
		for(int i = 0; i < ball.length; i++)
			System.out.print(ball[i] + " ");
		System.out.println();
		
		int	imsi	= 0; 	// 두 값을 바꾸는데 사용할 임시변수
		int	num		= 0;	// 임의의 정수 값을 구해서 저장할 변수
		
		for(int i = 0; i < 100; i++) {
			// 0 ~ 44 사이의 임의의 정수를 추출한다.
			num = (int)(Math.random() * ball.length);
			
			// 맨 처음 방의 값과 추출한 값에 해당하는 방의 값을 교환한다.
			imsi		= ball[0];	// ball[0]에 있는 값을 변수 imsi에 저장한다.
			ball[0] 	= ball[num];// 랜덤하게 찾은 정수에 해당하는 방의 값을 ball[0]에 저장한다.
			ball[num]	= imsi;
			//System.out.println("랜덤:" + num);
		}
		
		System.out.println();
		// 배열 ball의 앞에서 부터 6개를 출력한다.
		for(int i = 0; i < 6; i++)
			System.out.print(ball[i] + ", ");
		

	} // End - public static void main(String[] args)

} // End - public class Array05










