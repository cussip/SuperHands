package object.binding.binding3;

//-----------------------------------------------------------------------------------------------------------
// class Parent
//-----------------------------------------------------------------------------------------------------------
class Parent {
	int x = 100;
	void method() {
		System.out.println("Parent Method");
	}
} // End - class Parent
//-----------------------------------------------------------------------------------------------------------
// class Child extends Parent
//-----------------------------------------------------------------------------------------------------------
class Child extends Parent {
	int x = 200;
	void method() {
		System.out.println("x => " + x);
		System.out.println("super.x => " + super.x);
		System.out.println("this.x => " + this.x);
	}
} // End - class Child extends Parent
//-----------------------------------------------------------------------------------------------------------
// public class BindingExam
//-----------------------------------------------------------------------------------------------------------
public class BindingExam {

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		Parent	p	= new Parent();
		Child	c	= new Child();
		
		System.out.println("p.x => " + p.x);
		p.method();
		System.out.println("c.x =>" + c.x);
		c.method();

	} // End - public static void main(String[] args)

} // End - public class BindingExam







