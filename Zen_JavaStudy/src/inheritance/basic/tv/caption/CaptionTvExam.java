package inheritance.basic.tv.caption;

//-----------------------------------------------------------------------------------------------------------
// class Tv
//-----------------------------------------------------------------------------------------------------------
class Tv {
	boolean	power;		// 전원상태
	int		channel;	// 채널
	int		volume;		// 볼륨
	
	void	power()			{	power	= !power;	}
	void	channelUp()		{	++channel;			}
	void	channelDown()	{	--channel;			}
} // End - class Tv
//-----------------------------------------------------------------------------------------------------------
// class CaptionTv
//-----------------------------------------------------------------------------------------------------------
class CaptionTv extends Tv {
	boolean	caption;	// 자막상태
	void	displayCaption(String text) {
		if(caption) {	// 캡션 기능이 켜졌을 때(true)만 자막을 보여준다.
			System.out.println(text);
		}
	}
} // End - class CaptionTv
//-----------------------------------------------------------------------------------------------------------
// public class CaptionTvExam
//-----------------------------------------------------------------------------------------------------------
public class CaptionTvExam {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		
		CaptionTv ctv	= new CaptionTv();
		ctv.channel		= 10;				// 조상 클래스로부터 상속받은 멤버변수
		ctv.channelUp();					// 조상 클래스로부터 상속받은 멤버
		System.out.println("현재 채널 : " + ctv.channel);
		
		ctv.displayCaption("안녕하세요?");
		ctv.caption		= true;				// 캡션 기능을 켠다.
		ctv.displayCaption("안녕하세요?");	// 자막을 화면에 보여준다.

	} // End - public static void main(String[] args)

} // End - public class CaptionTvExam

















