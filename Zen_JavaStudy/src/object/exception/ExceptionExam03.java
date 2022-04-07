package object.exception;

public class ExceptionExam03 {

	public static void main(String[] args) {

		int	number	= 999;
		int	result	= 0;
		
		for(int i = 0; i < 10; i++) {
			result = number / (int)(Math.random() * 10);
			System.out.println(i + "번째 ==> " + result);
		}

	}

}
