package object.constructor.car02;

//-----------------------------------------------------------------------------------------------------------
// class Car
//-----------------------------------------------------------------------------------------------------------
class Car {
	String		color;		// 자동차의 색깔
	String		gearType;	// 변속기의 종류
	int			door;		// 문의 개수
	
	// 기본 사양 : 검정색, 수동, 문4짝
	Car() {
		this("검정", "수동", 4);
	}
	
	// 기본 사양 + 400만원 : 색상변경, 자동, 문4짝
	Car(String color) {
		this(color, "자동", 4);
	}
	
	// 기본 사양 + 1000만원 : 색상변경, 변속기 변경, 문짝 변경가능
	Car(String color, String gearType, int door) {
		this.color		= color;
		this.gearType	= gearType;
		this.door		= door;
	}
	
} // End - class Car

//-----------------------------------------------------------------------------------------------------------
// public class CarExam
//-----------------------------------------------------------------------------------------------------------
public class CarExam {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		Car c1	= new Car();
		System.out.println("C1 : " + c1.color + ", " + c1.gearType + ", " + c1.door);
		
		Car	c2	= new Car("파랑");
		System.out.println("C2 : " + c2.color + ", " + c2.gearType + ", " + c2.door);
		
		Car	c3	= new Car("빨강", "자동", 3);
		System.out.println("C3 : " + c3.color + ", " + c3.gearType + ", " + c3.door);
		
	} // End - public static void main(String[] args)

} // End - public class CarExam







