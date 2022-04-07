package condition;

public class Cond20 {

	public static void main(String[] args) {
		int sum = 0;
		int i   = 0;
		while(true) {
			sum += i;
			i++;
			if(sum > 100)
				break;
			System.out.println("i = " + i);
			System.out.println("sum = " + sum);
		}

	}

}
