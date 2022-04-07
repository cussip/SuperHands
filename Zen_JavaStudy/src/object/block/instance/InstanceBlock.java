package object.block.instance;

//-----------------------------------------------------------------------------------------------------------
// public class InstanceBlock
//-----------------------------------------------------------------------------------------------------------
public class InstanceBlock {
	
	{ // 인스턴스 블럭
		System.out.println("인스턴스 블럭이 실행됩니다.");
	}
	static { // 스태틱 블럭
		System.out.println("클래스 블럭이 실행됩니다.");
	}
	public InstanceBlock() {
		System.out.println("생성자가 실행됩니다.");
	}
	
	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		System.out.println("블럭 테스트 시작.....");
		InstanceBlock b1 = new InstanceBlock();
		
		InstanceBlock b2 = new InstanceBlock();

	} // End - public static void main(String[] args)

} // End - public class InstanceBlock
