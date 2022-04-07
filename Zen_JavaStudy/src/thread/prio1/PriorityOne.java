package thread.prio1;

//-----------------------------------------------------------------------------------------------------------
// class MessageSendingThread extends Thread
//-----------------------------------------------------------------------------------------------------------
class MessageSendingThread extends Thread {
	String	message;
	
	public MessageSendingThread(String str) {
		message = str;
	}
	public void run() {
		for(int i = 0; i < 1000000; i++) {
			System.out.println(message + "(우선순위:" + getPriority() + ")");
		}
	}
	
} // ENd - class MessageSendingThread extends Thread

//-----------------------------------------------------------------------------------------------------------
// public class PriorityOne
//-----------------------------------------------------------------------------------------------------------
public class PriorityOne {

	public static void main(String[] args) {
		MessageSendingThread tr1 = new MessageSendingThread("첫번째");
		MessageSendingThread tr2 = new MessageSendingThread("두번째");
		MessageSendingThread tr3 = new MessageSendingThread("세번째");

		tr1.start();
		tr2.start();
		tr3.start();
	}

} // End - public class PriorityOne












