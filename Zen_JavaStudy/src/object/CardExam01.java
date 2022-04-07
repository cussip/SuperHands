package object;

//-----------------------------------------------------------------------------------------------------------
// class Card
//-----------------------------------------------------------------------------------------------------------
class Card {
			String	kind;			// 카드의 무늬 - 인스턴스 변수
			int		number;			// 카드의 숫자 - 인스턴스 변수
	static	int		width	= 100;	// 카드의 폭   - 클래스   변수
	static	int		height	= 260;	// 카드의 높이 - 클래스   변수
} // End - class Card

//-----------------------------------------------------------------------------------------------------------
// public class CardExam01
//-----------------------------------------------------------------------------------------------------------
public class CardExam01 {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		// 클래스 변수는 클래스가 메모리에 로딩되면 바로 사용할 수 있다.
		System.out.println("카드의   폭 : " + Card.width);
		System.out.println("카드의 높이 : " + Card.height);
		// 인스턴스 변수는 객체를 생성해야 사용할 수가 있다.
		// System.out.println("카드의 숫자 : " + Card.number);
		
		Card c1		= new Card();
		c1.kind		= "Heart";
		c1.number	= 8;
		
		Card c2		= new Card();
		c2.kind		= "Diamond";
		c2.number	= 5;
		
		System.out.println("c1 => " + c1.kind + ", " + c1.number + ", " + c1.width + ", " + c1.height);
		System.out.println("c2 => " + c2.kind + ", " + c2.number + ", " + c2.width + ", " + c2.height);
		
		c1.width	= 140;
		c2.height	= 300;

		System.out.println("c1 => " + c1.kind + ", " + c1.number + ", " + c1.width + ", " + c1.height);
		System.out.println("c2 => " + c2.kind + ", " + c2.number + ", " + c2.width + ", " + c2.height);
	} // End - public static void main(String[] args)

} // End - public class CardExam01








