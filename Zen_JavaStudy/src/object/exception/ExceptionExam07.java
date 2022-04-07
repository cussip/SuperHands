package object.exception;

public class ExceptionExam07 {

	public static void main(String[] args) {

		try {
			// 먼저 연산자 new를 이용해서 발생시키고자 하는 예외 클래스의 객체를 만든다.
			Exception e = new Exception("고의로 예외를 발생시킨다.");
			
			// 키워드 throw를 이용해서 예외를 발생시킨다.
			throw e;
			
			// catch 문이 여러개 일 경우, 아래로 갈 수록 catch의 범위가 넓어져야 한다.
		} catch (ArithmeticException ae) { 
			System.out.println("수학적인 예외가 발생했습니다.");
		} catch (Exception e) {
			System.out.println("예외 메시지 : " + e.getMessage());
			e.printStackTrace();
		}
		
		System.out.println("프로그램이 정상적으로 종료되었습니다.");

	}

}
