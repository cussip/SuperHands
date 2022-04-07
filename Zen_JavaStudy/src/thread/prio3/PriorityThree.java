package thread.prio3;

//-----------------------------------------------------------------------------------------------------------
// class MessageSendingThread extends Thread
//-----------------------------------------------------------------------------------------------------------
class MessageSendingThread extends Thread {
	String	message;
	
	public MessageSendingThread(String str, int prio) {
		message	= str;
		setPriority(prio);
	}
	public void run() {
		for(int i = 0; i <= 10000000; i++) {
			System.out.println(message + "(우선순위:" + getPriority() + ")");
			
			try {
				sleep(1);	// 1000분의 1초 동안 잠재운다.
			} catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
} // End - class MessageSendingThread extends Thread

//-----------------------------------------------------------------------------------------------------------
// public class PriorityThree
//-----------------------------------------------------------------------------------------------------------
public class PriorityThree {

	public static void main(String[] args) {
		MessageSendingThread tr1	= new MessageSendingThread("첫번째", Thread.MAX_PRIORITY);	// 10
		MessageSendingThread tr2	= new MessageSendingThread("두번째", Thread.NORM_PRIORITY);	//  5
		MessageSendingThread tr3	= new MessageSendingThread("세번째", Thread.MIN_PRIORITY);	//  1

		tr1.start();
		tr2.start();
		tr3.start();
	}

} // End - public class PriorityThree










