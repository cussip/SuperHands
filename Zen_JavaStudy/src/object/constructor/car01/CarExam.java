package object.constructor.car01;

//-----------------------------------------------------------------------------------------------------------
// class Car
//-----------------------------------------------------------------------------------------------------------
class Car {
	String	color;		// 자동차의 색상
	String	gearType;	// 자동차의 변속기 종류 - auto(자동), manual(수동)
	int		door;		// 문의 개수
	
	Car() {} // 기본 생성자
	Car(String c, String g, int d) {
		color		= c;
		gearType	= g;
		door		= d;
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
		// 기본형 주문
		Car	c1	= new Car();
		c1.color	= "검정";
		c1.gearType	= "수동";
		c1.door		= 4;
		System.out.println("C1 => " + c1.color + ", " + c1.gearType + ", " + c1.door);

		Car c2	= new Car("빨강", "자동", 3);
		System.out.println("C2 => " + c2.color + ", " + c2.gearType + ", " + c2.door);
	} // End - public static void main(String[] args)

} // End - public class CarExam














