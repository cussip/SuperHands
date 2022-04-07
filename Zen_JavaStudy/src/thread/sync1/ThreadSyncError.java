package thread.sync1;

//-----------------------------------------------------------------------------------
// class Increment
//-----------------------------------------------------------------------------------
class Increment {
	int	num = 0;
	// 하나의 쓰레드가 이 메써드의 실행을 완료하지 않은 상태에서 
	//		다른 쓰레드도 이 메써드를 실행하기 때문에 문제가 발생한다.
	// 이를 해결하기 위해서 키워드 synchronized를 사용해서 '동기화 메서드'를 선언하거나,
	//		'동기화 블럭'을 지정해 주면 된다.
	// 동기화 메서드 로 해결 
	// ==>
	// 1. 정상적인 값이 출력된다.
	// 2. 실행시간이 오래 걸린다. 즉, 쓰레드의 동기화로 인해서 성능이 많이 저하되었다.
	//public synchronized void increment() {	
	public  void increment() {	
		synchronized(this) {
			num++;	
		}
	}
	public int	getNum()	{	return num;	}
} // End - class Increment

//-----------------------------------------------------------------------------------
// class IncThread extends Thread
//-----------------------------------------------------------------------------------
class IncThread extends Thread {
	Increment inc; // Increment 클래스를 가리키기 위한 참조변수를 선언
	
	public IncThread(Increment inc) {
		this.inc	= inc;
	}
	public void run() {
		for(int i = 0; i < 10000; i++)
			for(int j = 0; j < 10000; j++) {
				inc.increment();
			}
		System.out.println("쓰레드의 작업이 끝났습니다. 합계 : " + inc.getNum());
	} 
	
} // End - class IncThread extends Thread

//-----------------------------------------------------------------------------------
// public class ThreadSyncError
//-----------------------------------------------------------------------------------
public class ThreadSyncError {

	public static void main(String[] args) {

		Increment 	inc	= new Increment();
		IncThread	it1	= new IncThread(inc);
		IncThread	it2	= new IncThread(inc);
		IncThread	it3	= new IncThread(inc);

		it1.start();
		it2.start();
		it3.start();

		try {
			it1.join();	// 쓰레드가 일을 끝마치기 전까지 대기한다.
			it2.join();	// 쓰레드가 일을 끝마치기 전까지 대기한다.
			it3.join();	// 쓰레드가 일을 끝마치기 전까지 대기한다.
		} catch(InterruptedException ie) {
			ie.printStackTrace();
			System.out.println("계산 도중에 문제가 발생하였습니다.");
		}

		System.out.println("총합 : " + inc.getNum());
	}

} // End - public class ThreadSyncError










