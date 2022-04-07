package object;

//-----------------------------------------------------------------------------------------------------------
// public class MemberCall
//-----------------------------------------------------------------------------------------------------------
public class MemberCall {
			int	iv	= 10;
	static	int	cv	= 20;
	
			int	iv2	= cv;
	// 클래스변수는 인스턴스 변수를 사용할 수 없다. 인스턴스 변수가 아직 생성되지 않았으므로....
	// static	int	cv2 = iv; 에러발생
	static 	int cv2 = new MemberCall().iv;	// 객체를 생성한 후에 사용이 가능하다.

	static void staticMethod01() {
		System.out.println(cv); // 사용 가능
		// 클래스 메서드 안에서는 인스턴스 변수를 사용할 수가 없다.
		// System.out.println(iv); // 사용 불가능
		MemberCall mc = new MemberCall();
		System.out.println(mc.iv); // 객체를 생성한 후에야 인스턴스 변수의 참조가 가능하다.
	}
	
	void instanceMethod01() {
		System.out.println(cv);
		System.out.println(iv); // 인스턴스 메서드에서는 인스턴스 변수를 바로 사용이 가능하다.
	}
	
	static void staticMethod02() {
		staticMethod01();
		// instanceMethod01(); // 에러. 클래스 메서드에서는 인스턴스 메서드를 호출할 수 없다.
		MemberCall mc = new MemberCall();
		mc.instanceMethod01(); // 인스턴스를 생성한 후에야 인스턴스 메서드를 호출할 수 있다.
	}
	
	void instanceMethod02() {
		// 인스턴스 메서드에서는 인스턴스 메서드와 클래스 메서드를 
		// 모두 인스턴스 생성없이 바로 호출이 가능하다. 
		staticMethod01();
		instanceMethod01();
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		MemberCall mc = new MemberCall();
		// cv2 = mc.iv;

	} // End - public static void main(String[] args)

} // End - public class MemberCall
















