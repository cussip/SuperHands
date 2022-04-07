package object.phonebook.v2;

import java.util.Scanner;

//-----------------------------------------------------------------------------------------------------------
// class PhoneInfo
//-----------------------------------------------------------------------------------------------------------
class PhoneInfo {
	String	name;
	String	phoneNumber;
	String	birth;
	
	public PhoneInfo(String name, String num, String birth) {
		this.name	= name;
		phoneNumber	= num;
		this.birth	= birth;
	}
	public PhoneInfo(String name, String num) {
		this.name	= name;
		phoneNumber	= num;
		this.birth	= null;
	}
	public void showPhoneInfo() {
		System.out.println("-----------------------------------------------------------------");
		System.out.println("이    름 : " + name);
		System.out.println("전화번호 : " + phoneNumber);
		if(birth != null)
			System.out.println("생년월일 : " + birth);
	}
	
} // End - class PhoneInfo

//-----------------------------------------------------------------------------------------------------------
// public class PhoneBook02
//-----------------------------------------------------------------------------------------------------------
public class PhoneBook02 {
	static Scanner keyboard = new Scanner(System.in);
	
	// 메뉴
	public static void showMenu() {
		System.out.println("작업을 선택하세요.");
		System.out.println("1. 전화번호 입력");
		System.out.println("0. 프로그램 종료");
		System.out.print("선택 : ");
	}
	
	// 정보입력과 출력
	public static void readData() {
		System.out.print("이    름 : ");
		String	name	= keyboard.nextLine();
		
		System.out.print("전화번호 : ");
		String	phone	= keyboard.nextLine();
		
		System.out.print("생년월일 : ");
		String	birth	= keyboard.nextLine();
		
		// 입력받은 정보를 가지고 객체를 생성한다.
		PhoneInfo pInfo = new PhoneInfo(name, phone, birth);
		System.out.println("\n-----------------------------------------------------------");
		System.out.println("입력한 정보를 출력합니다.");
		pInfo.showPhoneInfo();
		
	}

	//-----------------------------------------------------------------------------------------------------------
	// public static void main(String[] args)
	//-----------------------------------------------------------------------------------------------------------
	public static void main(String[] args) {
		
		int choice;	// 메뉴를 선택한 값을 저장하는 변수 (0 => 종료, 1 ==> 입력)
		
		while(true) {
			showMenu();	// 선택할 메뉴를 보여준다.
			choice = keyboard.nextInt(); // 작업을 선택한다.
			keyboard.nextLine();
			
			switch(choice) {
				case 1:
					readData(); // 데이터를 입력하고, 입력한 데이터를 보여준다.
					break;
				case 0:
					System.out.println("프로그램을 종료합니다.");
					return;
				default:
					System.out.println("1 이나 0 을 입력하셔야 합니다.");
					break;
			}
		}

	} // End - public static void main(String[] args)

} // End - public class PhoneBook02











