package object.exception;

public class ExceptionExam04 {

	public static void main(String[] args) {

		int	number	= 999;
		int	result	= 0;
		
		for(int i = 0; i < 10; i++) {
			try {
				result = number / (int)(Math.random() * 10);
				System.out.println(i + "번째 ==> " +  result);
			} catch(ArithmeticException ae) {
				System.out.println("0으로 나눌 수 없습니다.");
			}
		}

	}

}
