package Backjoon_OJ.Bronze5;

import java.math.BigInteger;
import java.util.Scanner;

public class No2338 {
	public static void main(String[] args) throws Exception {
		Scanner sc = new Scanner(System.in);
		BigInteger n1 = sc.nextBigInteger();
		BigInteger n2 = sc.nextBigInteger();
		sc.close();
		
		System.out.println(n1.add(n2));
		System.out.println(n1.subtract(n2));
		System.out.println(n1.multiply(n2));
	}
}