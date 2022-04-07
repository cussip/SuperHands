package inheritance.basic.tv.tvcr;

//-----------------------------------------------------------------------------------------------------------
// class TV
//-----------------------------------------------------------------------------------------------------------
class TV {
	boolean	power;
	int		channel;
	
	void power()		{	power = !power;		}
	void channelUp()	{	++channel;			}
	void channelDown()	{	--channel;			}
} // End - class TV
//-----------------------------------------------------------------------------------------------------------
// class VCR
//-----------------------------------------------------------------------------------------------------------
class VCR {
	boolean	power;
	int		counter	= 0;
	
	void power()		{	power = !power;						}
	void play()			{	System.out.println("PLAY");			}
	void stop()			{	System.out.println("STOP");			}
	void rew()			{	System.out.println("REWIND");		}
	void ff()			{	System.out.println("Fast Forward");	}
} // End - class VCR
//-----------------------------------------------------------------------------------------------------------
// class TVCR
//-----------------------------------------------------------------------------------------------------------
class TVCR extends TV { 	// 상속
	VCR vcr = new VCR(); 	// 포함
	
	int counter = vcr.counter;
	void play()	{	vcr.play();		}
	void stop()	{	vcr.stop();		}
	void rew()	{	vcr.rew();		}
	void ff()	{	vcr.ff();		}
} // End - class TVCR
//-----------------------------------------------------------------------------------------------------------
// public class TVCRExam
//-----------------------------------------------------------------------------------------------------------
public class TVCRExam {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		TVCR tvcr = new TVCR();
		tvcr.channel	= 55;
		System.out.println(tvcr.channel);
		tvcr.play();
		tvcr.stop();

	} // End - public static void main(String[] args)

} // End - public class TVCRExam
