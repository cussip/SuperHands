package object;

//-----------------------------------------------------------------------------------------------------------
// class Card2 
//-----------------------------------------------------------------------------------------------------------
class Card2 {
	final 	int		NUMBER; // 상수이지만 선언고 함께 초기화 하지 않고,
	final 	String	KIND;	// 생성자에서 단 한번만 초기화할 수 있다.
	static	int		width	= 100;
	static	int		height	= 260;
	
	Card2(String kind, int num) { // 매개변수 있는 생성자
		KIND	= kind;
		NUMBER	= num;
	}
	
	Card2() {
		this("DIAMOND", 7);
	}
	
	public String toString() { // 오버라이딩
		return "" + KIND + ":" + NUMBER;
	}
	
} // End - class Card2 
//-----------------------------------------------------------------------------------------------------------
// public class FinalCardExam
//-----------------------------------------------------------------------------------------------------------
public class FinalCardExam {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Card2 c = new Card2("CLOVER", 8);
		// c.NUMBER = 3; <== final로 선언된 변수는 값이 처음 정해진 다음에는 바꿀수가 없다.
		c.width = 1000;
		System.out.println(c.width);
		System.out.println(c.height);
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		System.out.println(c);

	} // End - public static void main(String[] args)

} // End - public class FinalCardExam
