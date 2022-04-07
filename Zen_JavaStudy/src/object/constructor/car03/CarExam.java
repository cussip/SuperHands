package object.constructor.car03;

//-----------------------------------------------------------------------------------------------------------
// class Car
//-----------------------------------------------------------------------------------------------------------
class Car {
	String		color;		// 색상
	String		gearType;	// 변속기 종류
	int			door;		// 문의 개수
	int x;
	int y = x;
	
	Car() { // 기본 생성자
		this("검정", "수동", 4);
	}
	
	Car(Car c) { // 인스턴스의 복사를 위한 생성자
		color		= c.color;
		gearType	= c.gearType;
		door		= c.door;
	}
	
	Car(String color, String gearType, int door) { // 매개변수가 있는 생성자
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

		Car	c1	= new Car();
		Car	c2 	= new Car(c1);	// c1의 복사본 c2를 생성한다.
		
		System.out.println(c1);
		System.out.println(c2);

		System.out.println("C1 : " + c1.color + ", " + c1.gearType + ", " + c1.door);
		System.out.println("C2 : " + c2.color + ", " + c2.gearType + ", " + c2.door);
 
		c1.door = 10;	// c1 인스턴스변수 door의 값을 변경한다.
		System.out.println("c1의 door를 수리하고 난 후 ===> ");
		System.out.println("C1 : " + c1.color + ", " + c1.gearType + ", " + c1.door);
		System.out.println("C2 : " + c2.color + ", " + c2.gearType + ", " + c2.door);
		
		// c1 과 c2 는 별개의 객체이다.
		
		int count;	// 선언
		count = 10;	// 초기화
		System.out.println("카운트 : " + count);
		
		int x;
		//int y = x;
		
	} // End - public static void main(String[] args)

} // End - public class CarExam
















