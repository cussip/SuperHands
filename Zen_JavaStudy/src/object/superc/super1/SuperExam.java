package object.superc.super1;

//-----------------------------------------------------------------------------------------------------------
// class Parent 
//-----------------------------------------------------------------------------------------------------------
class Parent {
	int x = 10;
} // End - class Parent 
//-----------------------------------------------------------------------------------------------------------
// class Child extends Parent
//-----------------------------------------------------------------------------------------------------------
class Child extends Parent {
	void method() {
		System.out.println("x => " + x);
		System.out.println("this.x => " + this.x);
		System.out.println("super.x => " + super.x);
	}
} // End - class Child extends Parent
//-----------------------------------------------------------------------------------------------------------
// public class SuperExam
//-----------------------------------------------------------------------------------------------------------
public class SuperExam {
	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Child c = new Child();
		c.method();
	} // End - public static void main(String[] args)

} // End - public class SuperExam
