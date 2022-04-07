package object.parameter.param03;

//-----------------------------------------------------------------------------------------------------------
// public class ParameterExam03
//-----------------------------------------------------------------------------------------------------------
public class ParameterExam03 {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		int[] x = { 10 };	// 크기가 1인 배열. x[0] = 10;
		System.out.println("main() : x ==> " + x[0]); // x => 10

		change(x);
		System.out.println("After change(x)");
		System.out.println("main() : x => " + x[0]); // x => 1000
		
	} // End - public static void main(String[] args)
	
	//-----------------------------------------------------------------------------------------------------------
	// static void change(int[] x)
	//-----------------------------------------------------------------------------------------------------------
	static void change(int[] x) { // 참조형 매개변수
		System.out.println("Before change() : x => " + x[0]); // x => 
		x[0] = 1000;
		System.out.println("change() : x => " + x[0]); // x => 1000
	} // End - static void change(int[] x)

} // End - public class ParameterExam03








