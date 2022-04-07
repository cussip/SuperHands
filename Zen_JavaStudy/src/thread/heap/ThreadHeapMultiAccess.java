package thread.heap;

//-----------------------------------------------------------------------------------------------------------
// class Sum
//-----------------------------------------------------------------------------------------------------------
class Sum {
	int		num;
	public 	Sum()				{	num	= 0;	}
	public 	void addNum(int n)	{	num += n;	} 	// num에 n값을 누적시킨다.
	public 	int	getNum()		{	return num;	}	// num에 저장된 값을 읽어온다.
} // End - class Sum

//-----------------------------------------------------------------------------------------------------------
// class AdderThread extends Thread
//-----------------------------------------------------------------------------------------------------------
class AdderThread extends Thread {
	Sum	sumInst;
	int	start, end;
	
	public AdderThread(Sum sum, int s, int e) {
		sumInst	= sum;
		start	= s;
		end		= e;
	}
	public void run() {
		for(int i = start; i <= end; i++)
			sumInst.addNum(i);
	}
} // End - class AdderThread extends Thread

//-----------------------------------------------------------------------------------------------------------
// public class ThreadHeapMultiAccess
//-----------------------------------------------------------------------------------------------------------
public class ThreadHeapMultiAccess {

	public static void main(String[] args) {
		Sum			s	= new Sum();	// Sum 인스턴스를 생성한다.
		AdderThread at1 = new AdderThread(s,  1,  50);
		AdderThread at2	= new AdderThread(s, 51, 100);
		at1.start();
		at2.start();
		
		try {
			at1.join();
			at2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("1 ~ 100까지의 합 : " + s.getNum());	// 5050

	}

} // End - public class ThreadHeapMultiAccess








