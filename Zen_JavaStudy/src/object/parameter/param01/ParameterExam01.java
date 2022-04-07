package object.parameter.param01;

//-----------------------------------------------------------------------------------------------------------
// class Data
//-----------------------------------------------------------------------------------------------------------
class Data {
	int	x;
} // End - class Data

//-----------------------------------------------------------------------------------------------------------
// public class ParameterExam01
//-----------------------------------------------------------------------------------------------------------
public class ParameterExam01 {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Data d = new Data();
		d.x = 10;
		System.out.println("main() : x => " + d.x); // 10

		change(d.x);// ParameterExam01.change(d.x);
		System.out.println("After change(d.x)");
		System.out.println("main() : x => " + d.x); // 

		int count = 99;
		change(count);
		
	} // End - public static void main(String[] args)
	
	//-----------------------------------------------------------------------------------------------------------
	// static void change(int x)
	//-----------------------------------------------------------------------------------------------------------
	static void change(int x) { // 기본형 매개변수
		System.out.println("Before change() : x => " + x); // x => 10
		x = 1000;
		// d.x = 999;
		System.out.println("change() : x => " + x); // x => 1000
	} // End - static void change(int x)
	

} // End - public class ParameterExam01








