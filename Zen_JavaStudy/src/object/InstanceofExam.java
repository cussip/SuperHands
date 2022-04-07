package object;

//-----------------------------------------------------------------------------------------------------------
class Car {}
class FireTruck extends Car {}
//-----------------------------------------------------------------------------------------------------------
// public class InstanceofExam
//-----------------------------------------------------------------------------------------------------------
public class InstanceofExam {
	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		FireTruck ft = new FireTruck();
		
		if(ft instanceof FireTruck) {
			System.out.println("This is a FireTruck instance.");
		}
		if(ft instanceof Car) {
			System.out.println("This is a Car instance.");
		}
		if(ft instanceof Object) {
			System.out.println("This is an Object instance.");
		}

	} // End - public static void main(String[] args)

} // End - public class InstanceofExam






