package array;

public class Array07 {

	public static void main(String[] args) {
		//int[] num;
		//num = new int[5];
		int[] num = new int[5];
		// num = {1,2,3,4,5}; // Error
		num[0] = 1; num[1] = 2; num[2] = 3; num[3] = 4; num[4] = 5;
		
		int[] number		= {1, 2, 3, 4, 5};
		int[] newNumber		= new int[10];
		
		for(int i = 0; i < newNumber.length; i++)
			System.out.print(newNumber[i] + ", ");
		System.out.println();
		
		/*
		newNumber[0] = number[0];
		newNumber[1] = number[1];
		newNumber[2] = number[2];
		newNumber[3] = number[3];
		newNumber[4] = number[4];
		*/
		for(int i = 0; i < number.length; i++)
			newNumber[i+3] = number[i];
		
		for(int i = 0; i < newNumber.length; i++)
			System.out.print(newNumber[i] + ", ");
	}

}












