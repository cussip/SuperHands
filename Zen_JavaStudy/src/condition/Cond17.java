package condition;

public class Cond17 {

	public static void main(String[] args) {
		// while()문을 이용하여 구구단을 만들어보자.
		int x = 1;
		int y = 1;
		while(x <= 9) {
			while(y <= 9) {
				System.out.print(x + "x" + y + "=" + (x*y) + "\t");
				y++;
			}
			x++;
			y = 1;
			System.out.println();
		}
	}

}
