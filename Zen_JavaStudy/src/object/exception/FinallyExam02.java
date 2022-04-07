package object.exception;

public class FinallyExam02 {

	public static void main(String[] args) {

		FinallyExam02.method();
		
		System.out.println("method()의 실행을 끝마치고 main()메서드로 복귀했습니다.");
	}
	
	static void method() {
		try {
			System.out.println("method() 메서드가 호출되었습니다.");

			System.out.println(0/0);
			
			return;
		} catch (Exception e) {
			//System.out.println("예외발생");
			e.printStackTrace();
		} finally {
			System.out.println("method() 메서드의 finally블럭이 실행되었습니다.");
		}
		System.out.println("요기를 실행할까요?");
	}

}









