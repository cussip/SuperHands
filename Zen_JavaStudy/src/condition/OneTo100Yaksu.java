package condition;

public class OneTo100Yaksu {

	public static void main(String[] args) {
		// 1 부터 100까지 각 정수들의 약수들을 모두 구해보자.
		/*
		1 의 약수 : 1, 
		2 의 약수 : 1, 2, 
		3 의 약수 : 1, 3, 
		4 의 약수 : 1, 2, 4, 
		5 의 약수 : 1, 5, 
		6 의 약수 : 1, 2, 3, 6, 
		7 의 약수 : 1, 7, 
		8 의 약수 : 1, 2, 4, 8, 
		*/
		for(int num = 1; num <= 100; num++) {
			System.out.print(num + " 의 약수 : ");
			for(int j = 1; j <= num; j++) {
				// 약수를 화면에 보여준다.
				if(num % j == 0) {
					//if(num == j)	System.out.print(j);
					//else			System.out.print(j + ", ");
					System.out.print(j);
					if(num != j)	System.out.print(", ");
				}
			}
			System.out.println();
		}

	}

}










