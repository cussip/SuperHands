package object.fruit.fruit01;

//-----------------------------------------------------------------------------------------------------------
// class FruitSeller : 과일 판매자
//-----------------------------------------------------------------------------------------------------------
class FruitSeller {
			int	numOfApple	= 200;	// 시장에 판매하러 가지고 나갈 사과의 개수
			int	myMoney		= 0;	// 돈주머니
	final 	int	APPLE_PRICE	= 1000;	// 사과 한개당 판매 가격
	final	String APPLE_NAME = "맛있는 사과";
	
	// 사과를 판매하는 행위 : 돈을 받고(매개변수) 사과를 준다(리턴)
	public int saleApple(int money) {
		int	num	= money / APPLE_PRICE;	// 돈을 받고 판매할 사과의 개수
		numOfApple  -= num;				// 사과보유개수에서 판매한 수량만큼 차감한다.
		myMoney		+= money;			// 판매수익을 주머니에 넣는다.
		return	num;					// 구매자에게 사과를 준다.
	}
	
	// 사과를 판매하고 난 후의 현황보기
	public void showSaleResult() {
		System.out.println("남은 사과 개수 : " + numOfApple);
		System.out.println("판매 수익 금액 : " + myMoney);
	}
	
} // End - class FruitSeller
//-----------------------------------------------------------------------------------------------------------
// class FruitBuyer : 과일 구매자
//-----------------------------------------------------------------------------------------------------------
class FruitBuyer {
	int	myMoney		= 10000;	// 과일 구매자의 보유 금액
	int	numOfApple	= 0;		// 과일 주머니
	
	// 사과를 구매하는 행위
	public void buyApple(FruitSeller seller, int money) {
		System.out.println("buyApple() seller => " + seller);
		myMoney		-= money;					// 구매한 금액만큼 돈주머니에서 돈을 차감한다.
		numOfApple 	= seller.saleApple(money);	// 사과장수에게 돈을 주고, 사과를 받는다.
	}
	
	// 구매한 현황 보기
	public void showBuyResult() {
		System.out.println("현재 잔액 : " + myMoney);
		System.out.println("사과 개수 : " + numOfApple);
	}
	
} // End - class FruitBuyer
//-----------------------------------------------------------------------------------------------------------
// public class FruitSalesExam01
//-----------------------------------------------------------------------------------------------------------
public class FruitSalesExam01 {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		
		FruitSeller	seller	= new FruitSeller();	// 사과장수 등장
		FruitBuyer	buyer	= new FruitBuyer();		// 구매자 등장
		
		System.out.println("main() seller => " + seller);
		buyer.buyApple(seller, 3000);	// 사과장수에게 3000원어치 사과를 구매한다.
		
		System.out.println("사과장수의 판매 현황");
		seller.showSaleResult();
		
		System.out.println("구매자의 구매 현황");
		buyer.showBuyResult();
		
		FruitBuyer	buyer2	= new FruitBuyer();		// 구매자 등장
		buyer2.buyApple(seller, 3000);	// 사과장수에게 3000원어치 사과를 구매한다.

		System.out.println("사과장수의 판매 현황");
		seller.showSaleResult();
		
		System.out.println("구매자의 구매 현황");
		buyer2.showBuyResult();
		
		
		
	} // End - public static void main(String[] args)

} // End - public class FruitSalesExam01
















