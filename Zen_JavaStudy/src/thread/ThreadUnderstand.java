package thread;

//-----------------------------------------------------------------------------------------------------------
// 쓰레드 생성 방법 1 : Thread 클래스를 상속받아 만든다.
//-----------------------------------------------------------------------------------------------------------
class ShowThread extends Thread {
	String	threadName;
	
	public ShowThread(String name) {
		threadName	= name;
	}
	
	public void run() { // run() <== 쓰레드의 메인
		for(int i = 0; i < 100; i++) {
			System.out.println("안녕하세요. 저는 " + threadName + " 입니다.");
			try {
				sleep(100);	// 1초 == 1000
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
} // End - class ShowThread extends Thread

//-----------------------------------------------------------------------------------------------------------
// public class ThreadUnderstand
//-----------------------------------------------------------------------------------------------------------
public class ThreadUnderstand {

	public static void main(String[] args) {

		ShowThread st1 = new ShowThread("멋있는 쓰레드");
		ShowThread st2 = new ShowThread("귀여운 쓰레드");
		ShowThread st3 = new ShowThread("얄미운 쓰레드");
		st1.start(); // st1.start(); ==> 쓰레드에 있는 run() 메서드를 구동시킨다.
		st2.start(); // st2.start(); ==> 쓰레드에 있는 run() 메서드를 구동시킨다.
		st3.start(); // st3.start(); ==> 쓰레드에 있는 run() 메서드를 구동시킨다.
		
		st1.run(); 	// 쓰레드로 작동하는 것이 아니라 일반 메서드로 작동한다.
		st2.run(); 	// 쓰레드로 작동하는 것이 아니라 일반 메서드로 작동한다.
		st3.run(); 	// 쓰레드로 작동하는 것이 아니라 일반 메서드로 작동한다.
		
		System.out.println("모든 쓰레드의 작업이 끝날 때까지 남아있지 않고........");
		System.out.println("프로세스는 할 일이 없으므로 먼저 집에 갑니다..........");
	}

} // End - public class ThreadUnderstand









