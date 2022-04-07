package object.block.instance;

//-----------------------------------------------------------------------------------------------------------
// public class StaticBlock
//-----------------------------------------------------------------------------------------------------------
public class StaticBlock {
	static int[] arr = new int[10];
	
	static {
		for(int i = 0; i < arr.length; i++) 
			System.out.println(arr[i]);

		for(int i = 0; i < arr.length; i++) {
			arr[i] = (int) (Math.random() * 10) + 1;
		}
	}

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		for(int i = 0; i < arr.length; i++) {
			System.out.println("arr[" + i + "] : " + arr[i]);
		}

	} // End - public static void main(String[] args)

} // public class StaticBlock













