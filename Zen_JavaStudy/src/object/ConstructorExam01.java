package object;

//-----------------------------------------------------------------------------------------------------------
// class Data01
//-----------------------------------------------------------------------------------------------------------
class Data01 {
	int value;
	// 기본 생성자
	Data01() {
		System.out.println("저는 기본 생성자 입니다.");
	} 
} // End - class Data01
//-----------------------------------------------------------------------------------------------------------
// class Data02
//-----------------------------------------------------------------------------------------------------------
class Data02 {
	int value;
	Data02() {
		System.out.println("Data02의 기본 생성자입니다.");
	}
	Data02(int x) { // 매개변수가 있는 생성자.
		value = x;
	}
} // End - class Data02
//-----------------------------------------------------------------------------------------------------------
// public class ConstructorExam01
//-----------------------------------------------------------------------------------------------------------
public class ConstructorExam01 {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Data01 d1 = new Data01();
		// Data02 d2 = new Data02(); // 기본생성자를 실행시키게 된다.
		Data02 d2 = new Data02(100);
		System.out.println(d2.value);

	} // End - public static void main(String[] args)

} // End - public class ConstructorExam01




















