package object.block.instance;

//-----------------------------------------------------------------------------------------------------------
// class Product
//-----------------------------------------------------------------------------------------------------------
class Product {
	static int count = 0;	// 생성된 인스턴스의 수를 저장하기 위한 변수(제품이 총 몇대 생산되었는지 알기 위해서)
	int	serialNo;			// 인스턴스 고유의 번호
	
	{
		++count;	// 제품이 생산되었으므로 총 생산대수를 1 증가시킨다.
		serialNo	= count;
	}
	
} // End - class Product

//-----------------------------------------------------------------------------------------------------------
// public class ProductExam
//-----------------------------------------------------------------------------------------------------------
public class ProductExam {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {

		Product p1 = new Product();
		Product p2 = new Product();
		Product p3 = new Product();

		System.out.println("p1의 제품번호 : " + p1.serialNo);
		System.out.println("p2의 제품번호 : " + p2.serialNo);
		System.out.println("p3의 제품번호 : " + p3.serialNo);
		System.out.println("총 생산 대수 : " + Product.count);
		
		
	} // End - public static void main(String[] args)

} // End - public class ProductExam
