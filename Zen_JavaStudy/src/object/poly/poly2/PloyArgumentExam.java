package object.poly.poly2;

class Product {
	int	price;
	int	bonusPoint;
	
	// 판매가격을 정한 경우
	Product(int price) {
		this.price		= price;
		this.bonusPoint	= this.price/10;
	}
	// 판매가격을 못 정한 경우
	Product() {
		price		= 0;
		bonusPoint	= 0;
	}
}

class Tv extends Product {
	Tv() {
		super(100);
	}
	public String toString() {
		return "텔레비전";
	}
}

class Bicycle extends Product {
	Bicycle() {
		super(50);
	}
	public String toString() {
		return "자전거";
	}
}

class Audio extends Product {
	Audio() {
		super(70);
	}
	public String toString() {
		return "오디오";
	}
}

class NoteBook extends Product {
	NoteBook() {
		super(150);
	}
	public String toString() {
		return "노트북";
	}
}

class SportsCar extends Product {
	SportsCar() {
		super();
	}
	public String toString() {
		return "스포츠 카";
	}
}

class Buyer {
	int	money		= 1000;
	int bonusPoint	= 0;
	Product[] item	= new Product[10];	// 구입한 제품을 저장하기 위한 배열
	int	count		= 0;				// Product배열에 사용될 카운트
	
	void buy(Product p) {	// 구매 행위
		if(p.price <= 0) {
			System.out.println("판매하는 제품이 아닙니다.");
			return;
		}
		if(money < p.price) {
			System.out.println("돈이 모자라서 물품을 구매할 수가 없습니다.");
			return;
		}
		money			-= p.price;		// 가진 돈에서 구매한 물품의 가격을 뺀다.
		bonusPoint		+= p.bonusPoint;// 보너스 점수를 챙긴다.
		item[count++]	= p;			// 구매한 제품의 목록을 Product[] item에 저장한다.
		System.out.println(p + "을/를 구입하였습니다.");
	}
	
	// 구매현황 보기
	void summary() {	// 구매한 제품에 대한 정보를 요약해서 보여준다.	
		int		sum			= 0;	// 구입한 물품의 가격합계
		String	itemList	= "";	// 구입한 물품목록
		
		// 반복문을 이용하여 구입한 물품의 총 금액과 목록을 만든다.
		for(int i = 0; i < item.length; i++) {
			if(item[i] == null)	break;
			sum			+= item[i].price;
			itemList	+= item[i] + ", ";
		}
		System.out.println("구매한 물품의 총 금액은 " + sum + "만원입니다.");
		System.out.println("구매한 제품들은 " + itemList + "입니다.");
	}
}

public class PloyArgumentExam {

	public static void main(String[] args) {
		Tv			tv		= new Tv();
		Bicycle		bc		= new Bicycle();
		Audio		audio	= new Audio();
		NoteBook	nbook	= new NoteBook();
		SportsCar	sCar	= new SportsCar();
		
		Buyer		buyer	= new Buyer();

		buyer.buy(tv);
		buyer.buy(bc);
		buyer.buy(audio);
		buyer.buy(nbook);

		buyer.buy(sCar);
		
		buyer.summary();
	}

}











