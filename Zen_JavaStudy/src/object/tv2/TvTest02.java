package object.tv2;

//-----------------------------------------------------------------------------------------------------------
// class Tv
//-----------------------------------------------------------------------------------------------------------
class Tv {
	// Tv의 속성(멤버변수)
	String		color;		// 색상
	boolean		power;		// 전원상태
	int			channel;	// 채널
	
	// Tv의 기능(Method)
	void	power()			{	power	= !power;	}
	void 	channelUp()		{	++channel;			}
	void	channelDown()	{	--channel;			}
} // End - class Tv

//-----------------------------------------------------------------------------------------------------------
// public class TvTest02
//-----------------------------------------------------------------------------------------------------------
public class TvTest02 {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		Tv	t1	= new Tv();
		Tv	t2	= new Tv();
		
		System.out.println("t1의 채널 : " + t1.channel);
		System.out.println("t2의 채널 : " + t2.channel);
		
		t1.channel = 7;
		System.out.println("t1의 채널을 변경하였습니다.");

		System.out.println("t1의 채널 : " + t1.channel);
		System.out.println("t2의 채널 : " + t2.channel);
	}

} // End - public static void main(String[] args)












