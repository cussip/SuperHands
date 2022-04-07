package inheritance.basic;

//-----------------------------------------------------------------------------------------------------------
// public class DeckExam
//-----------------------------------------------------------------------------------------------------------
public class DeckExam {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		Deck d	= new Deck();	// 카드 한 벌을 만든다.
		Card c	= d.pick(0);	// 카드를 섞기 전에 제일 위의 카드를 뽑는다.
		System.out.println("맨위의 카드 ==> " + c);
		
		d.shuffle();	// 카드를 섞는다.
		c = d.pick(0);	// 카드를 섞은 후에 맨 위의 카드를 뽑는다.
		System.out.println("카드를 섞은 후의 맨위의 카드 ==> " + c);
		
	} // End - public static void main(String[] args)

} // End - public class DeckExam

//-----------------------------------------------------------------------------------------------------------
// class Deck
//-----------------------------------------------------------------------------------------------------------
class Deck {
	final	int	CARD_NUM = 52;	// 카드의 개수
	Card c[] = new Card[CARD_NUM];
	
	Deck() { // 기본 생성자
		// Deck의 카드를 초기화 한다.
		int i = 0;
		
		// 카드 52장을 무늬별로 13장씩 만든다.
		for(int k = Card.KIND_MAX; k > 0; k--) {
			for(int n = 1; n <= Card.NUM_MAX; n++) {
				c[i++] = new Card(k, n);
			}
		}
	}
		
	Card pick(int index) { // 지정된 위치(index)에 있는 카드를 하나 뽑는다.
		if(0 <= index && index < CARD_NUM)
			return c[index];
		else
			return pick();
	}
	
	Card pick() { // Deck에서 임의의 카드 한장을 뽑는다.
		int index = (int) (Math.random() * CARD_NUM);
		return pick(index);
	}
			
	void shuffle() { // 카드를 섞는다.
		for(int n = 0; n < 1000; n++) {
			int i = (int) (Math.random() * CARD_NUM);
			Card temp	= c[0];
			c[0]		= c[i];
			c[i]		= temp;
		}
	}
			
	
} // End - class Deck
//-----------------------------------------------------------------------------------------------------------
// class Card
//-----------------------------------------------------------------------------------------------------------
class Card {
	static 	final 	int	KIND_MAX	= 4;	// 카드 무늬의 개수
	static	final	int	NUM_MAX		= 13;	// 무늬별 카드의 개수
	
	static	final	int	SPADE		= 4;
	static	final	int	DIAMOND		= 3;
	static	final	int	HEART		= 2;
	static	final	int	CLOVER		= 1;
	
	int		kind;	// 카드의 무늬
	int		number;	// 카드의 숫자
	
	Card() {
		this(SPADE, 1);
		// System.out.println("111"); 생성자를 호출하는 것보다 다른 명령이 앞에 올 수 없다.
	}
	
	Card(int kind, int number) {
		this.kind	= kind;
		this.number	= number;
	}
	
	public String toString() {
		String	kind	= "";
		String	number	= "";
		
		switch(this.kind) {
			case 4:	kind = "SPADE";		break;
			case 3:	kind = "DIAMOND";	break;
			case 2:	kind = "HEART";		break;
			case 1:	kind = "CLOVER";	break;
		}
		
		switch(this.number) {
			case 13: number = "K";	break;
			case 12: number = "Q"; 	break;
			case 11: number = "J";	break;
			default: number = this.number + "";
		}
		
		return "kind : " + kind + ", number : " + number;
	}
	
} // End - class Card













