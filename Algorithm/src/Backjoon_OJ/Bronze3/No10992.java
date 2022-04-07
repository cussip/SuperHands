package Backjoon_OJ.Bronze3;
import java.util.Scanner;

public class No10992 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		
		for(int i = 0; i < num; i++) {
			for(int j = num - i - 1; j > 0; j--) {
				System.out.print(" ");
			}
			System.out.print("*");
			
			if(i > 0 && i != num - 1) {
				for(int k = 0; k < i * 2 - 1; k++) {
					System.out.print(" ");
				}				
				System.out.print("*");
			} else if (i == num - 1) {
				for(int n = 0; n < num * 2 - 2; n++) {
					System.out.print("*");
				}
			}			
			System.out.println();
		}	
	}
}
