package object.poly.poly3;

import java.util.Vector;

class Product {
	int	price;
	int	bonusPoint;
	
	Product(int price) {
		this.price	= price;
		bonusPoint	= price/10;
	}
}

class Tv extends Product {
	Tv() 						{	super(100);			}
	public String toString()	{	return "텔레비젼";	}
}
class Computer extends Product {
	Computer()					{	super(150);			}
	public String toString()	{	return "컴퓨터";	}
}
class Audio extends Product {
	Audio()						{	super(70);			}
	public String toString()	{	return "오디오";	}
}

class Buyer {
	int		money		= 1000;
	int 	bonusPoint	= 0;
	Vector	item		= new Vector();	// 구매한 제품을 저장하는데 사용할 Vector 객체
	
	void buy(Product p) {
		if(money < p.price) {
			System.out.println("돈이 모자라서 " + p + "을/를 살수가 없어요.");
			return;
		}
		money		-= p.price;		// 돈을 지불하고
		bonusPoint	+= p.bonusPoint;// 보너스 점수를 챙긴다.
		item.add(p);				// 구매한 제품을 Vector에 저장한다.
		System.out.println(p + "을/를 구입하였습니다.");
	}
	
	void refund(Product p) {	// 구입한 물품을 반품하는 행위
		if(item.remove(p)) {	// 구입한 제품을 Vector에서 제거한다.
			money		+= p.price;		// 제품가격을 돌려받고
			bonusPoint	-= p.bonusPoint;// 보너스 점수는 돌려준다.
			System.out.println(p + "을/를 반품하였습니다.");
		} else {
			System.out.println("구입한 제품들 중에 해당하는 제품이 없습니다.");
		}
	}
	
	void summary() {	// 구입한 물품에 대한 정보를 요약해서 보여준다.
		int		sum			= 0;	// 구입한 물품들의 총 가격
		String	itemList	= "";	// 구입한 물품목록
		
		// Vector가 비어있는지 확인한다.
		if(item.isEmpty()) {
			System.out.println("구매하신 제품이 하나도 없습니다.");
			return;
		}
		
		// 반복문을 이용해서 구입한 물품의 총 가격과 목록을 만든다.
		for(int i = 0; i < item.size(); i++) {
			// Vector 객체에서 i번째에 있는 객체의 정보를 얻어온다.
			Product p = (Product)item.get(i);
			sum 		+= p.price;
			// 쉼표를 먼저 붙인 다음에 제품명을 보여준다.
			// 단, 맨처음 구매한 제품은 앞에 쉼표를 붙이지 않는다.
			itemList	+= (i == 0) ? "" + p : ", " + p;
		}
		System.out.println("구매한 제품의 총구매가 : " + sum + "만원입니다.");
		System.out.println("구매한 제품들은 " + itemList + "입니다.");
	}
}

public class PolyArgumentExam {

	public static void main(String[] args) {
		Tv 			tv 	= new Tv();
		Computer	com	= new Computer();
		Audio		aud	= new Audio();
		
		Buyer		b	= new Buyer();
		
		b.buy(tv);
		b.buy(com);
		b.buy(aud);
		b.summary();
		
		b.refund(com);
		b.summary();
	}

}





