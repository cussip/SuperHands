package object.exception;

public class ExceptionExam06 {

	public static void main(String[] args) {

		System.out.println(1);
		System.out.println(2);
		
		try {
			System.out.println(3);
			System.out.println(0/0);
			// 예외가 발생하면 나머지 부분은 실행하지 않고, catch 블럭을 실행한다.
			System.out.println(4);
		} catch (ArithmeticException e) {
			System.out.println(5);
		}
		
		System.out.println(6);
	}

}








