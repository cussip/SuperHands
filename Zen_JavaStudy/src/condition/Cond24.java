package condition;

public class Cond24 {

	public static void main(String[] args) {
		// 1 + (-2) + 3 + (-4) + 5 + ...........과 같이 계속 더해나갔을 때
		// 100이상이 되는지 구하십시오.
		int sum = 0;	// 총합을 저장할 변수
		int s	= 1;	// 값의 부호를 변경하는데 사용할 변수
		int	num	= 0;	// 부호를 곱해서 저장할 변수
		
		for(int i = 1; true; i++, s = -s) { // -s = -1 x s;
			//if(i % 2 == 0)
			//	num = -1 * i;
			num = s * i;
			sum = sum + num; // 부호를 적용한 숫자를 누적시킨다.
			//System.out.println(num + ":" + sum);
			
			// for문을 벗어나려면 for문안에서 벗어나는 조건을 주어야 한다.
			if(sum >= 100)
				break;
			
		}
		System.out.println("num : " + num);
		System.out.println("sum : " + sum);
	}

}
