package variable;

public class Vari09 
{

	public static void main(String[] args) 
	{
		int numOfApples  = 257;	// 내가 가지고 있는 사과의 갯수
		int	sizeOfBucket =  10; // 바구니에 담을 수 있는 사과의 갯수
		
		int	numOfBucket  = 0; // 바구니의 갯수
		
		numOfBucket = numOfApples / sizeOfBucket 
					+ (numOfApples % sizeOfBucket > 0 ? 1 : 0);
		
		System.out.println("사과를 담을 바구니의 갯수 : " + numOfBucket);

	}

}
