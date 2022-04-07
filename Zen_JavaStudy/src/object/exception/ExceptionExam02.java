package object.exception;

public class ExceptionExam02 {

	public static void main(String[] args) {
		
		try {
			// 예외가 발생할 가능성이 있는 문장을 기술한다.
			
			try {  } catch(Exception e) { }
		} catch (Exception e) {
			
			try {  } catch(Exception e1) { } // catch 블럭 내에서 같은 참조변수의 이름을 사용하면 않된다.
			// try {  } catch(Exception e) { } // catch 블럭 내에서 같은 참조변수의 이름을 사용하면 않된다.
		}
		
		try {
			
		} catch(Exception e) {
			System.out.println("예외가 발생하였습니다.");
		}

	}

}
