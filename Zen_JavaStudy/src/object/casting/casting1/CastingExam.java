package object.casting.casting1;

//-----------------------------------------------------------------------------------------------------------
// class Car
//-----------------------------------------------------------------------------------------------------------
class Car {
	String	color;
	int		door;
	
	void drive() {	// 움직이는 기능
		System.out.println("자동차가 지나갑니다.");
	}
	void stop() { // 자동차가 멈추는 기능
		System.out.println("자동차가 멈춥니다.");
	}
} // End - class Car
//-----------------------------------------------------------------------------------------------------------
// class FireTruck extends Car
//-----------------------------------------------------------------------------------------------------------
class FireTruck extends Car {
	void water() {	// 물을 뿌리는 기능
		System.out.println("소방차가 물을 뿌립니다.");
	}
} // End - class FireTruck extends Car
//-----------------------------------------------------------------------------------------------------------
// public class CastingExam
//-----------------------------------------------------------------------------------------------------------
public class CastingExam {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
	
		Car			car = null;
		FireTruck	ft1	= new FireTruck();
		FireTruck	ft2 = null;
		
		ft1.water();
		car = ft1; // car = (Car) ft1; 에서 형변환이 생략된 것이다.
		// car.water(); <=== Compile Error : Car  타입의 참조변수로 자손의 메서드인 water()를 호출할 수 없다.
		ft2 = (FireTruck) car; // 조상타입 ===> 자손타입 일 경우에는 (타입)을 꼭 기술해야 한다.
		ft2.water();
		
	} // End - 	public static void main(String[] args)

} // End - public class CastingExam
