package object.superc.super4;

//-----------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------
class Point {
	int x, y;
	//Point() {}
	Point(int x, int y) {
		this.x = x;		this.y = y;
	}
}
//-----------------------------------------------------------------------------------------------------------
//-----------------------------------------------------------------------------------------------------------
class Point3D extends Point {
	int z;
	Point3D() {
		super(3,4);
	}
	Point3D(int x, int y, int z) {
		super(1, 2);
		System.out.println("super : " + super.x + " , " + super.y);
		System.out.println("this  : " + this.x + " , " + this.y);
		this.x = x; 
		this.y = y;
		this.z = z;
		System.out.println("super : " + super.x + " , " + super.y);
		System.out.println("this  : " + this.x + " , " + this.y);
		this.x = 100;
		this.y = 200;
		System.out.println("super : " + super.x + " , " + super.y);
		System.out.println("this  : " + this.x + " , " + this.y);
	}
}
//-----------------------------------------------------------------------------------------------------------
// public class PointExam
//-----------------------------------------------------------------------------------------------------------
public class PointExam {
	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Point3D p3 = new Point3D(11, 22, 33);
		System.out.println("Point3D를 생성하였습니다.");
	}

} // End - public class PointExam
