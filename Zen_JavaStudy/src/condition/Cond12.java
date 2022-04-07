package condition;

public class Cond12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int i = 1;
		
		for( ; i <= 10 ; i++) {
			sum += i; // sum = sum + i;
			System.out.println(i);
		}
		// 지역변수는 자기 지역을 벗어나면 사용할 수가 없다.
		System.out.println("1부터 " + (i -1) + "까지의 합 : " + sum); 
		

	}

}
