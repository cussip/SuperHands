package thread;

//-----------------------------------------------------------------------------------------------------------
// class Sum
//-----------------------------------------------------------------------------------------------------------
class Sum {
	int		num;
	public 	Sum()				{	num = 0;	}
	public	void addNum(int n)	{	num += n;	}
	public	int	 getNum()		{	return num;	}
} // End - class Sum

//-----------------------------------------------------------------------------------------------------------
// class AdderThread extends Sum implements Runnable
//-----------------------------------------------------------------------------------------------------------
class AdderThread extends Sum implements Runnable {
	int	start, end;	// 누적된 값을 저장하기 위한 시작과 마지막 값을 담을 변수
	
	public AdderThread(int s, int e) {
		start	= s;
		end		= e;
	}

	@Override
	public void run() {
		for(int i = start; i <= end; i++)
			addNum(i);
	}
	
} // End - class AdderThread extends Sum implements Runnable

//-----------------------------------------------------------------------------------------------------------
// public class RunnableThread
//-----------------------------------------------------------------------------------------------------------
public class RunnableThread {

	public static void main(String[] args) {
		AdderThread	at1 = new AdderThread(  1, 100);
		AdderThread	at2 = new AdderThread(101, 200);
		AdderThread at3	= new AdderThread(201, 300);
		
		Thread		tr1	= new Thread(at1);
		Thread		tr2	= new Thread(at2);
		Thread		tr3	= new Thread(at3);
		
		tr1.start();
		tr2.start();
		tr3.start();
		
		try {
			// .join() <== 이는 해당 쓰레드가 종료될 때까지 실행을 멈출 때 호출하는 메서드이다.
			tr1.join();
			tr2.join();
			tr3.join();
		} catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("1 부터 300까지의 합 : " + (at1.getNum() + at2.getNum() + at3.getNum()));
	}

} // End - public class RunnableThread









