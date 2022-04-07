package object.poly.poly1;

class Product {
	int	price;		// 제품의 가격
	int	bonusPoint;	// 제품 구매시 제공하는 보너스 점수
	
	Product(int price) {
		this.price		= price;
		bonusPoint		= price/10;	// 보너스 점수는 제품가격의 10%로 정한다.
	}
}

class Tv extends Product {
	Tv() {
		// 조상클래스의 생성자 Product(int price)를 호출한다.
		super(100);	// Tv의 값을 100만원으로 설정한다.
		// this.price 		= 100;
		// this.bonusPoint	= this.price/10;
	}
	public String toString() { // Object 클래스의 toString()을 오버라이딩한다.
		return "Tv";
	}
}

class Computer extends Product {
	Computer() {
		super(200);
	}
	public String toString() {
		return "Computer";
	}
}

class Buyer {	// 고객, 물건을 구입하는 사람
	int	money		= 1000;	// 소유금액
	int	bonusPoint	= 0;	// 물건을 구입하고 받은 보너스 점수
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("금액이 모자라서 물건을 살 수가 없습니다.");
			return;
		}
		money		-= p.price;			// 가진 돈에서 물건 가격을 차감한다.
		bonusPoint	+= p.bonusPoint;	// 구매한 제품의 보너스 점수를 받는다.
		System.out.println(p + "을/를 구매하였습니다.");
	}
}

public class PolyArgumentExam {

	public static void main(String[] args) {
		Tv			tv		= new Tv();
		Computer	com		= new Computer();
		Buyer		buyer	= new Buyer();
		
		buyer.buy(tv);
		buyer.buy(com);
		
		System.out.println("현재 남은 돈은 " + buyer.money + "만원입니다.");
		System.out.println("현재 보너스 점수는 " + buyer.bonusPoint + "점입니다.");

	}

}












