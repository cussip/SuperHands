package array;

public class Array08 {

	public static void main(String[] args) {
		char[] abc = {'A', 'B', 'C', 'D'};
		char[] num = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
		
		// 배열 abc와 배열 num을 붙여서 담을 하나의 새로운 배열을 만든다.
		char[] result = new char[abc.length + num.length];
		// System.arraycopy(원본배열, 읽을 시작위치, 복사할 배열, 복사할 시작위치, 길이);
		System.arraycopy(abc, 0, result, 0, abc.length);
		System.arraycopy(num, 0, result, abc.length, num.length);
		
		for(int i = 0; i < result.length; i++)
			System.out.print(result[i] + ", ");
	}

}
