package thread.sync2;

//-----------------------------------------------------------------------------------------------------------
// class Calculator
//-----------------------------------------------------------------------------------------------------------
class Calculator {
	int optCnt	= 0;	// 연산 횟수를 저장할 변수
	
	//public synchronized int plus(int num1, int num2) {
	public int plus(int num1, int num2) {
		synchronized(this) {
			optCnt++;	// 동기화가 필요한 부분
		}
		return num1+num2;
	}
	//public synchronized int minus(int num1, int num2) {
	public int minus(int num1, int num2) {
		synchronized(this) {
			optCnt++;	// 동기화가 필요한 부분
		}
		return num1-num2;
	}
	public void showOpCnt() {
		System.out.println("총 연산 횟수 : " + optCnt);
	}
	
} // End - class Calculator

//-----------------------------------------------------------------------------------------------------------
// 더하기 쓰레드
//-----------------------------------------------------------------------------------------------------------
class PlusThread extends Thread {
	Calculator cal;
	
	public PlusThread(Calculator cal) {
		this.cal	= cal;
	}
	public void run() {
		System.out.println("1 + 2 = " + cal.plus(1, 2));
		System.out.println("2 + 4 = " + cal.plus(2, 4));
	}
	
} // End - class PlusThread extends Thread

//-----------------------------------------------------------------------------------------------------------
// 빼기 쓰레드
//-----------------------------------------------------------------------------------------------------------
class MinusThread extends Thread {
	Calculator cal;
	
	public MinusThread(Calculator cal) {
		this.cal	= cal;
	}
	public void run() {
		System.out.println("2 - 1 = " + cal.minus(2, 1));
		System.out.println("4 - 2 = " + cal.minus(4, 2));
	}
	
} // End - class MinusThread extends Thread

//-----------------------------------------------------------------------------------------------------------
// public class ThreadSyncMethod
//-----------------------------------------------------------------------------------------------------------
public class ThreadSyncMethod {

	public static void main(String[] args) {
		Calculator	cal	= new Calculator();
		PlusThread	pt	= new PlusThread(cal);
		MinusThread	mt	= new MinusThread(cal);
		
		pt.start();
		mt.start();
		
		try {
			pt.join();
			mt.join();
		} catch (InterruptedException ie) {
			ie.printStackTrace();
		}

		cal.showOpCnt(); // 연산이 몇 번 일어났는지 보여준다.
	}

} // End - public class ThreadSyncMethod











