package condition;

public class Cond11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		
		for(int i = 1 ; i <= 10 ; i++) {
			sum += i; // sum = sum + i;
		}
		// 지역변수는 자기 지역을 벗어나면 사용할 수가 없다.
		//////System.out.println(i + "까지의 합 : " + sum); // 에러 발생
		
	}

}
