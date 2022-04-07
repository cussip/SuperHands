package object;

//-----------------------------------------------------------------------------------------------------------
// public class ReturnExam01
//-----------------------------------------------------------------------------------------------------------
public class ReturnExam01 {

	//-----------------------------------------------------------------------------------------------------------
	// int max(int num1, int num2)
	//-----------------------------------------------------------------------------------------------------------
	int max(int num1, int num2) {
		/*
		if(num1 > num2) {
			return num1;
		} else {
			return num2;
		}
		*/
		int result = 0;
		
		if(num1 > num2)	result = num1;
		else			result = num2;
		return result;
		
	} // End - int max(int num1, int num2)
	
	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		// static 이 않붙은 메서드는 먼저 클래스를 생성한 다음에 사용할 수가 있다.
		ReturnExam01 re = new ReturnExam01();
		int num = re.max(10, 50);
		System.out.println("큰 수 : " + num);

	} // End - public static void main(String[] args)

} // End - public class ReturnExam01
