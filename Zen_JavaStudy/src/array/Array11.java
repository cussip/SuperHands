package array;

public class Array11 {

	public static void main(String[] args) {
		// 큰 금액의 동전을 먼저 거슬러 주고, 나머지 돈은 작은 단위의 동전으로 거슬러 주도록 한다.
		// 내가 가지고 있는 돈을 거슬러 주려면 동전은 각각 몇개씩 필요한가요?
		// 500(5), 100(4), 50(1), 10(2)
		int[] coinUnit = { 500, 100, 50, 10 }; // 동전의 종류
		
		int myMoney = 2970; // 내가 가지고 있는 돈
		
		for(int i = 0; i < coinUnit.length; i++) {
			System.out.println(coinUnit[i] + "원 :" + myMoney / coinUnit[i] + "개"); 
			myMoney %= coinUnit[i]; // myMoney = myMoney % coinUnit[i];
		}

	} // End - public static void main(String[] args)

} // End - public class Array11








