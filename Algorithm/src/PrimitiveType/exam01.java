package PrimitiveType;

public class exam01 {

	public static void main(String[] args) {
		int n = 100;
		System.out.println("countBits(" + n + "): " + countBits(n));
	}
	
	public static short countBits(int x) {
		short numBits = 0;
		while (x != 0) {
			numBits += (x & 1);
			System.out.println("numBits: " + numBits);
			x >>>= 1;
			System.out.println("x: " + x);
			System.out.println("-----");
		}
		return numBits;
	}
	
}
