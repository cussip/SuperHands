package object.fruit.fruit02;

//-----------------------------------------------------------------------------------------------------------
// class FruitSeller : 사과 장수
//-----------------------------------------------------------------------------------------------------------
class FruitSeller {
	int	numOfApple;		// 판매할 사과의 개수
	int	myMoney;		// 벌어들이는 돈
	int	APPLE_PRICE;	// 사과 1개당 판매금액
	
	// 사과를 판매하는 기능
	public int saleApple(int money) {
		int	num		= money / APPLE_PRICE;	// 돈을 받고 줄 사과의 개수를 계산한다.
		myMoney		+= money;		// 돈을 받는다.
		numOfApple	-= num;			// 받은 돈만큼 사과의 개수를 줄인다.
		return		num;			// 사과를 구매자 한테 준다.
	} // End - public int saleApple(int money)
	
	// 판매 현황
	public void showSaleResult() {
		System.out.println("남은 사과 : " + numOfApple);
		System.out.println("판매 수익 : " + myMoney);
	} // End - public void showSaleResult()
	
	// 사과장사를 하기 위해 필요한 값들을 초기화
	// 사과 장수마다 수익금액, 사과의 개수, 사과 한개당 판매금액이 모두 다르게 적용하기 위해서 만든 메서드
	public void initMembers(int money, int appleNum, int price) {
		myMoney		= money;	// 돈주머니
		numOfApple	= appleNum;	// 판매할 사과의 개수
		APPLE_PRICE	= price;	// 사과 한개당 판매 금액
	}
	
} // End - class FruitSeller

//-----------------------------------------------------------------------------------------------------------
// class FruitBuyer : 사과를 구매하는 사람
//-----------------------------------------------------------------------------------------------------------
class FruitBuyer {
	int	myMoney		= 10000;	// 보유 현금
	int	numOfApple	= 0;		// 사과 바구니
	
	// 사과를 구매하는 행위
	public void buyApple(FruitSeller seller, int money) {
		numOfApple 	+= seller.saleApple(money); // 구매한 만큼 사과의 개수를 누적시키기 위해서 += 을 사용한다.
		myMoney		-= money;					// 사과를 구매한 만큼 주머니에서 계속 차감시키기 위해서 -= 을 사용한다.
	} // End - public void buyApple(FruitSeller seller, int money)
	
	// 구매 현황
	public void showBuyResult() {
		System.out.println("현재 잔액 : " + myMoney);
		System.out.println("사과 개수 : " + numOfApple);
	} // End - public void showBuyResult()
	
} // End - class FruitBuyer

//-----------------------------------------------------------------------------------------------------------
// public class FruitSalesExam02
//-----------------------------------------------------------------------------------------------------------
public class FruitSalesExam02 {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		FruitSeller	seller1	= new FruitSeller();
		seller1.initMembers(0, 100, 1500); // 수익금액, 사과의 개수, 사과 한개당 판매금액

		FruitSeller	seller2	= new FruitSeller();
		seller2.initMembers(0, 200, 1300); // 수익금액, 사과의 개수, 사과 한개당 판매금액

		FruitSeller	seller3	= new FruitSeller();
		seller3.initMembers(0, 150, 1100); // 수익금액, 사과의 개수, 사과 한개당 판매금액
		
		FruitBuyer	buyer1	= new FruitBuyer();
		buyer1.buyApple(seller1, 3000);
		buyer1.buyApple(seller2, 3900);
		
		FruitBuyer	buyer2	= new FruitBuyer();
		buyer2.buyApple(seller3, 5500);
		
		System.out.println("구매자 1 의 현황");
		buyer1.showBuyResult();
		System.out.println("구매자 2 의 현황");
		buyer2.showBuyResult();
		
		System.out.println("사과장수 1 의 판매현황");
		seller1.showSaleResult();
		System.out.println("사과장수 2 의 판매현황");
		seller2.showSaleResult();
		System.out.println("사과장수 3 의 판매현황");
		seller3.showSaleResult();

	} // End - public static void main(String[] args)

} // End - public class FruitSalesExam02











