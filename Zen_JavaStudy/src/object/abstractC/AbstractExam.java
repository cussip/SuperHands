package object.abstractC;

abstract class Cat {	// 추상 메서드를 하나라도 가지고 있으면 추상 클래스이다.
	abstract void call();	// 추상 메서드(선언부만 있고, 구현부는 없는 메서드)
	void callTwo() {
		System.out.println("야옹!");
	}
	abstract void run();
}

class FirstCat extends Cat {
	void call() {
		System.out.println("첫번째 고양이가 야옹하고 울었습니다.");
	}
	void run() {
		System.out.println("첫번째 고양이가 달려갑니다.");
	}
}

class SecondCat extends Cat {
	void call() {
		System.out.println("두번째 고양이가 밥을 달라고 합니다.");
	}
	void run() {
		System.out.println("두번째 고양이도 달려갑니다.");
	}
}

public class AbstractExam {

	public static void main(String[] args) {
		FirstCat	firstC	= new FirstCat();
		SecondCat	secondC	= new SecondCat();
		
		firstC.call();
		firstC.callTwo();
		firstC.run();
		
		secondC.call();
		secondC.callTwo();
		secondC.run();
	}

}







