package array;

public class Array12 {

	public static void main(String[] args) {
		// 돈은 큰단위의 동전부터 거슬러 주세요.
		// 동전으로 교환하고 남은 돈 ?
		// 교환하고 남은 동전의 갯수 ?
		int		myMoney			= 2990;					// 내가 가지고 있는 돈
		int[]	coinUnit		= { 500, 100, 50, 10 }; // 동전의 단위
		int[]	coin			= {   5,   5,  5,  5 }; // 각 동전의 수량
		
		System.out.println("동전으로 교환할 나의 돈 : " + myMoney + "원");
		for(int i = 0; i < coinUnit.length; i++) { // 동전으로 교환하는 횟수
			int coinNum = 0; // 필요한 동전의 갯수를 구하기 위해서 사용할 변수
			
			// 1. 나의 돈을 동전단위로 바꿀 동전의 갯수를 구한다.
			coinNum = myMoney / coinUnit[i];
			
			// 2. 배열 coin에서 coinUnit 만큼의 동전을 줄인다.
			// 가지고 있는 동전의 갯수가 바꾸어 줄 만큼 수량이 충분하거나 같으면 차감한다.
			if(coin[i] >= coinNum) {
				coin[i] -= coinNum; // coin[i] = coin[i] - coinNum;
			} else {
				// 바꿀 동전의 갯수가 보유한 동전의 갯수보다 더 필요하면 있는 동전을 모두 바꾸어 준다.
				coinNum = coin[i];
				coin[i] = 0;
			}
			// 3. 나의 돈에서 동전을 바꾼만큼의 돈을 차감한다.
			myMoney -= coinNum * coinUnit[i];
			System.out.println(coinUnit[i] + "원을 " + coinNum + "개 바꾸어 주었습니다.");
		}
		
		if(myMoney > 0) {
			System.out.println("동전으로 교환하고 남은 돈 : " + myMoney);
		}
		System.out.println("남은 동전의 갯수");
		for(int i = 0; i < coinUnit.length; i++)
			System.out.println(coinUnit[i] + "원 : " + coin[i] + "개");
		
	} // End - public static void main(String[] args)

} // End - public class Array12
