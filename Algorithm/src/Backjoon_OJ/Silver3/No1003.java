package Backjoon_OJ.Silver3;

public class No1003 {

	public static void main(String[] args) {
		System.out.println(fibo(10));
	
	}

	static int fibo(int n) {
		if(n == 0) {
			return 0;
		} else if(n == 1) {
			return 1;
		} else {
			return fibo(n - 1) + fibo(n - 2);
		}
	}
}
	