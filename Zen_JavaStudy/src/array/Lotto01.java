package array;

//-------------------------------------------------------------------------------------------------
// public class Lotto01
//-------------------------------------------------------------------------------------------------
public class Lotto01 {

	//-------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		// 1 부터 45 까지의 정수 중에서 6개의 수를 추출한다.
		// 단, 추출한 6개의 수는 서로 중복이 되면 않된다.
		// ==> 중복된 수가 나올 경우에는 어떻게 처리할 해야되나?
		// 배열의 방은 6개만 사용한다.
		int[] ball = new int[6];
		
		// 6개의 정수를 추출한다.
		for(int now = 0; now < ball.length; now++) {
			ball[now] = (int)(Math.random() * 45) + 1;
			// 중복된 수가 있으면 다시 추출한다.
			// now 가 0 인 경우는 비교할 대상이 없으므로, 비교에서 제외시킨다.
			for(int old = 0; now > 0 && old < now; old++) {
				if(ball[old] == ball[now]) { // 지금 추출한 번호가 앞에서 뽑은 번호가 같으면
					now--; // 추출작업을 다시한다.
				}
			}
		}
		
		for(int i = 0; i < ball.length; i++)
			System.out.print(ball[i] + ", ");
		System.out.println();
		
		// 추출한 번호를 오름차순으로 정렬한다.
		// 열(가로방향) : 2장씩 비교하므로 방크기-1 만큼만 반복하면 된다.
		for(int i = 0; i < ball.length-1; i++) { // 행(세로방향)
			for(int j = 0; j < ball.length-1-i; j++) { // 열(가로방향)
				if(ball[j] > ball[j+1]) { // 왼쪽 방의 값이 오른쪽 방의 값보다 크면 교환한다.
					int	imsi	= ball[j];
					ball[j]		= ball[j+1];
					ball[j+1]	= imsi;
				}
			}
		}

		// 중복되지 않게 추출된 수를 보여주자!
		for(int i = 0; i < ball.length; i++)
			System.out.print(ball[i] + ", ");
		
	} // End - public static void main(String[] args)

} // End - public class Lotto01














