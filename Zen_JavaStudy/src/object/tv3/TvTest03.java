package object.tv3;

//-----------------------------------------------------------------------------------------------------------
// class Tv
//-----------------------------------------------------------------------------------------------------------
class Tv {
	String		color;
	boolean		power;
	int			volumn;
	
	void	power()			{	power	= !power;	}
	void	volumnUp()		{	++volumn;			}
	void	volumnDown()	{	--volumn;			}
} // End - class Tv

//-----------------------------------------------------------------------------------------------------------
// public class TvTest03
//-----------------------------------------------------------------------------------------------------------
public class TvTest03 {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		Tv t1	= new Tv();
		Tv t2	= new Tv();
		
		System.out.println(t1);
		System.out.println(t2);
		
		System.out.println("t1의 볼륨 : " + t1.volumn);
		System.out.println("t2의 볼륨 : " + t2.volumn);
		
		t2 			= t1;
		t1.volumn	= 8;

		System.out.println("t1의 볼륨 : " + t1.volumn);
		System.out.println("t2의 볼륨 : " + t2.volumn);
		
		System.out.println(t1);
		System.out.println(t2);
	} // End - public static void main(String[] args)

} // End - public class TvTest03







