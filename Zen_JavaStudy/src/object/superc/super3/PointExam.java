package object.superc.super3;

//-----------------------------------------------------------------------------------------------------------
// class Point
//-----------------------------------------------------------------------------------------------------------
class Point {
	int x, y;
	Point(int x, int y) {
		this.x	= x;
		this.y	= y;
	}
	String getLocation() {
		return "x:" + x + ", y:" + y;
	}
} // End - class Point
//-----------------------------------------------------------------------------------------------------------
// class Point3D extends Point
//-----------------------------------------------------------------------------------------------------------
class Point3D extends Point {
	int z;
	Point3D(int x, int y, int z) {
		super(11, 22);
		this.x	= x;
		this.y	= y;
		this.z	= z;
	}
	String getLocation() { // 오버라이딩
		System.out.println("super x:" + super.x + ", y:" + super.y);
		return "x:" + x + ", y:" + y + ", z:" + z;
	}
} // End - class Point3D extends Point
//-----------------------------------------------------------------------------------------------------------
// public class PointExam
//-----------------------------------------------------------------------------------------------------------
public class PointExam {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Point3D p3 = new Point3D(10, 20, 30);
		System.out.println(p3.getLocation());
	}

} // End - public class PointExam
