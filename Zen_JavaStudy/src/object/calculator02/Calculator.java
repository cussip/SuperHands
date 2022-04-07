package object.calculator02;

//-----------------------------------------------------------------------------------------------------------
// class Calc
//-----------------------------------------------------------------------------------------------------------
class Calc {
	long x, y;
	
	// 인스턴스 변수와 상관없이 매개변수만으로 작업이 가능하다.
	static	long	plus(long x, long y)		{	return x + y;	}
	static	long	minus(long x, long y)		{	return x - y;	}
	static	long 	multiply(long x, long y)	{	return x * y;	}
	static	long	divide(long x, long y)		{	return x / y;	}
	
	// 인스턴스 변수 x, y를 이용하여 작업을 하므로 매개변수가 필요없다.
	long	plus()		{	return x + y;	}
	long	minus()		{	return x - y;	}
	long	multiply()	{	return x * y;	}
	long	divide()	{	return x / y ;	}
} // End - class Calc

//-----------------------------------------------------------------------------------------------------------
// public class Calculator
//-----------------------------------------------------------------------------------------------------------
public class Calculator {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		System.out.println(Calc.plus(300L, 100L));
		System.out.println(Calc.minus(300L, 100L));
		System.out.println(Calc.multiply(300L, 100L));
		System.out.println(Calc.divide(300L, 100L));
		
		// 인스턴스 메서드를 사용하려면 먼저 클래스를 생성하고, 참조변수를 사용한다.
		Calc calc 	= new Calc();
		calc.x		= 500L;
		calc.y		= 200L;
		
		// 인스턴스 메서드는 객체를 생성한 후에만 호출이 가능하다.
		System.out.println(calc.plus());
		System.out.println(calc.minus());
		System.out.println(calc.multiply());
		System.out.println(calc.divide());

	} // End - public static void main(String[] args)

} // End - public class Calculator







